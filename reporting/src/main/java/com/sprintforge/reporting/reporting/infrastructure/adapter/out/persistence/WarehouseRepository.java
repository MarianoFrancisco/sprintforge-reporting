package com.sprintforge.reporting.reporting.infrastructure.adapter.out.persistence;

import com.sprintforge.reporting.reporting.application.port.out.persistence.LoadExpense;
import com.sprintforge.reporting.reporting.application.port.out.persistence.LoadIncome;
import com.sprintforge.reporting.reporting.application.port.out.persistence.LoadProfit;
import com.sprintforge.reporting.reporting.application.service.internal.*;
import com.sprintforge.reporting.reporting.infrastructure.adapter.out.persistence.projection.EmployeePaymentDetailView;
import com.sprintforge.reporting.reporting.infrastructure.adapter.out.persistence.projection.PayrollExpenseSummaryView;
import com.sprintforge.reporting.reporting.infrastructure.adapter.out.persistence.projection.ProjectPaymentDetailView;
import com.sprintforge.reporting.reporting.infrastructure.adapter.out.persistence.projection.ProjectTotalView;
import com.sprintforge.reporting.reporting.infrastructure.adapter.out.persistence.projection.ProfitExpenseView;
import com.sprintforge.reporting.reporting.infrastructure.adapter.out.persistence.projection.ProfitIncomeView;
import com.sprintforge.reporting.reporting.infrastructure.adapter.out.persistence.repository.WarehouseJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

@Repository
@RequiredArgsConstructor
public class WarehouseRepository implements LoadProfit, LoadExpense, LoadIncome {

    private final WarehouseJpaRepository warehouseJpaRepository;

    @Override
    public Income loadIncome(
            LocalDate from,
            LocalDate to,
            IncomeSubtotal subtotalType,
            UUID onlyProjectId
    ) {

        List<ProjectTotalView> projectTotals =
                warehouseJpaRepository.projectTotals(from, to, onlyProjectId);

        List<ProjectPaymentDetailView> paymentDetails =
                warehouseJpaRepository.projectPaymentDetails(from, to, onlyProjectId);

        Map<UUID, List<IncomePaymentRow>> paymentsByProject = new HashMap<>();

        for (ProjectPaymentDetailView p : paymentDetails) {
            UUID projectId = p.getProjectId();
            List<IncomePaymentRow> list = paymentsByProject.computeIfAbsent(projectId, k -> new ArrayList<>());

            IncomePaymentRow row = new IncomePaymentRow(p.getDate(), p.getMethod(), p.getAmount());
            list.add(row);
        }

        List<ProjectIncomeBlock> blocks = new ArrayList<>(projectTotals.size());

        for (ProjectTotalView t : projectTotals) {

            ProjectTotalRow projectRow = new ProjectTotalRow(
                    t.getProjectId(),
                    t.getProjectKey(),
                    t.getProjectName(),
                    t.getTotal()
            );

            String subtotalLabel;
            if (subtotalType == IncomeSubtotal.CLIENT) {
                subtotalLabel = t.getClient();
            } else {
                subtotalLabel = t.getArea();
            }

            List<IncomePaymentRow> payments = paymentsByProject.get(t.getProjectId());
            if (payments == null) {
                payments = List.of();
            } else {
                payments = List.copyOf(payments);
            }

            BigDecimal subtotal = t.getTotal();

            ProjectIncomeBlock block = new ProjectIncomeBlock(projectRow, subtotalLabel, payments, subtotal);
            blocks.add(block);
        }

        return new Income(from, to, subtotalType, List.copyOf(blocks));
    }

    @Override
    public Expense loadExpense(LocalDate from, LocalDate to) {

        List<EmployeePaymentDetailView> rows = warehouseJpaRepository.employeePaymentDetails(from, to);

        Map<UUID, EmployeeAccumulator> acc = new LinkedHashMap<>();

        for (EmployeePaymentDetailView r : rows) {
            UUID employeeId = r.getEmployeeId();

            EmployeeAccumulator a = acc.get(employeeId);
            if (a == null) {
                a = new EmployeeAccumulator(employeeId, r.getFullName());
                acc.put(employeeId, a);
            }

            EmployeePaymentRow paymentRow = new EmployeePaymentRow(
                    r.getDate(),
                    r.getBaseSalary(),
                    r.getBonus(),
                    r.getDeduction(),
                    r.getTotal()
            );

            a.payments.add(paymentRow);
            a.subtotal = a.subtotal.add(r.getTotal());
        }

        List<EmployeeExpenseDetail> employees = new ArrayList<>(acc.size());
        for (EmployeeAccumulator a : acc.values()) {
            EmployeeExpenseDetail detail = new EmployeeExpenseDetail(
                    a.employeeId,
                    a.fullName,
                    List.copyOf(a.payments),
                    a.subtotal
            );
            employees.add(detail);
        }

        PayrollExpenseSummaryView s = warehouseJpaRepository.payrollExpenseSummary(from, to);
        PayrollExpenseSummary summary = new PayrollExpenseSummary(
                s.getBaseSalary(),
                s.getBonus(),
                s.getDeduction(),
                s.getTotal()
        );

        return new Expense(from, to, List.copyOf(employees), summary);
    }

    @Override
    public Profit loadProfit(LocalDate from, LocalDate to) {

        List<ProfitIncomeView> incomeViews = warehouseJpaRepository.profitIncomeRows(from, to);
        List<ProfitIncomeRow> incomes = new ArrayList<>(incomeViews.size());

        for (ProfitIncomeView r : incomeViews) {
            ProfitIncomeRow row = new ProfitIncomeRow(
                    r.getDate(),
                    r.getProjectKey(),
                    r.getProjectName(),
                    r.getClient(),
                    r.getArea(),
                    r.getMethod(),
                    r.getAmount()
            );
            incomes.add(row);
        }

        BigDecimal totalIncome = warehouseJpaRepository.totalIncome(from, to);

        List<ProfitExpenseView> expenseViews = warehouseJpaRepository.profitExpenseRows(from, to);
        List<ProfitExpenseRow> expenses = new ArrayList<>(expenseViews.size());

        for (ProfitExpenseView r : expenseViews) {
            ProfitExpenseRow row = new ProfitExpenseRow(
                    r.getDate(),
                    r.getEmployeeId(),
                    r.getFullName(),
                    r.getBaseSalary(),
                    r.getBonus(),
                    r.getDeduction(),
                    r.getTotal()
            );
            expenses.add(row);
        }

        BigDecimal totalExpense = warehouseJpaRepository.totalPayrollExpense(from, to);
        BigDecimal profit = totalIncome.subtract(totalExpense);

        return new Profit(
                from,
                to,
                List.copyOf(incomes),
                totalIncome,
                List.copyOf(expenses),
                totalExpense,
                profit
        );
    }

    private static final class EmployeeAccumulator {
        private final UUID employeeId;
        private final String fullName;
        private final List<EmployeePaymentRow> payments;
        private BigDecimal subtotal;

        private EmployeeAccumulator(UUID employeeId, String fullName) {
            this.employeeId = employeeId;
            this.fullName = fullName;
            this.payments = new ArrayList<>();
            this.subtotal = BigDecimal.ZERO;
        }
    }
}
