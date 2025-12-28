package com.sprintforge.reporting.reporting.infrastructure.adapter.out.persistence.repository;

import com.sprintforge.reporting.reporting.infrastructure.adapter.out.persistence.entity.DimProjectEntity;
import com.sprintforge.reporting.reporting.infrastructure.adapter.out.persistence.projection.*;
import org.jspecify.annotations.NullMarked;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@NullMarked
public interface WarehouseJpaRepository extends JpaRepository<DimProjectEntity, UUID> {

    @Query(value = """
                SELECT
                    p.project_id  AS projectId,
                    p.project_key AS projectKey,
                    p.name        AS projectName,
                    p.client      AS client,
                    p.area        AS area,
                    COALESCE(SUM(f.amount), 0) AS total
                FROM fact_project_payment f
                JOIN dim_project p ON p.project_id = f.project_id
                WHERE f.date >= COALESCE(?1, f.date)
                  AND f.date <= COALESCE(?2, f.date)
                  AND p.is_deleted = false
                  AND p.project_id = COALESCE(?3, p.project_id)
                GROUP BY p.project_id, p.project_key, p.name, p.client, p.area
                ORDER BY p.project_key
            """, nativeQuery = true)
    List<ProjectTotalView> projectTotals(
            LocalDate from,
            LocalDate to,
            UUID projectId
    );

    @Query(value = """
                SELECT
                    f.project_id AS projectId,
                    f.date       AS date,
                    f.method     AS method,
                    f.amount     AS amount
                FROM fact_project_payment f
                JOIN dim_project p ON p.project_id = f.project_id
                WHERE f.date >= COALESCE(?1, f.date)
                  AND f.date <= COALESCE(?2, f.date)
                  AND p.is_deleted = false
                  AND p.project_id = COALESCE(?3, p.project_id)
                ORDER BY f.project_id, f.date
            """, nativeQuery = true)
    List<ProjectPaymentDetailView> projectPaymentDetails(
            LocalDate from,
            LocalDate to,
            UUID projectId
    );

    @Query(value = """
                SELECT COALESCE(SUM(f.amount), 0)
                FROM fact_project_payment f
                JOIN dim_project p ON p.project_id = f.project_id
                WHERE f.date >= COALESCE(?1, f.date)
                  AND f.date <= COALESCE(?2, f.date)
                  AND p.is_deleted = false
            """, nativeQuery = true)
    BigDecimal totalIncome(
            LocalDate from,
            LocalDate to
    );

    @Query(value = """
                SELECT
                    f.employee_id AS employeeId,
                    e.full_name   AS fullName,
                    f.date        AS date,
                    f.base_salary AS baseSalary,
                    f.bonus       AS bonus,
                    f.deduction   AS deduction,
                    f.total       AS total
                FROM fact_employee_payment f
                JOIN dim_employee e ON e.employee_id = f.employee_id
                WHERE f.date >= COALESCE(?1, f.date)
                  AND f.date <= COALESCE(?2, f.date)
                ORDER BY e.full_name, f.date
            """, nativeQuery = true)
    List<EmployeePaymentDetailView> employeePaymentDetails(
            LocalDate from,
            LocalDate to
    );

    @Query(value = """
                SELECT
                    COALESCE(SUM(f.base_salary), 0) AS baseSalary,
                    COALESCE(SUM(f.bonus), 0)       AS bonus,
                    COALESCE(SUM(f.deduction), 0)   AS deduction,
                    COALESCE(SUM(f.total), 0)       AS total
                FROM fact_employee_payment f
                WHERE f.date >= COALESCE(?1, f.date)
                  AND f.date <= COALESCE(?2, f.date)
            """, nativeQuery = true)
    PayrollExpenseSummaryView payrollExpenseSummary(
            LocalDate from,
            LocalDate to
    );

    @Query(value = """
                SELECT COALESCE(SUM(f.total), 0)
                FROM fact_employee_payment f
                WHERE f.date >= COALESCE(?1, f.date)
                  AND f.date <= COALESCE(?2, f.date)
            """, nativeQuery = true)
    BigDecimal totalPayrollExpense(
            LocalDate from,
            LocalDate to
    );

    @Query(value = """
                SELECT
                    f.date        AS date,
                    p.project_key AS projectKey,
                    p.name        AS projectName,
                    p.client      AS client,
                    p.area        AS area,
                    f.method      AS method,
                    f.amount     AS amount
                FROM fact_project_payment f
                JOIN dim_project p ON p.project_id = f.project_id
                WHERE f.date >= COALESCE(?1, f.date)
                  AND f.date <= COALESCE(?2, f.date)
                  AND p.is_deleted = false
                ORDER BY f.date, p.project_key
            """, nativeQuery = true)
    List<ProfitIncomeView> profitIncomeRows(
            LocalDate from,
            LocalDate to
    );

    @Query(value = """
                SELECT
                    f.date        AS date,
                    f.employee_id AS employeeId,
                    e.full_name   AS fullName,
                    f.base_salary AS baseSalary,
                    f.bonus       AS bonus,
                    f.deduction   AS deduction,
                    f.total       AS total
                FROM fact_employee_payment f
                JOIN dim_employee e ON e.employee_id = f.employee_id
                WHERE f.date >= COALESCE(?1, f.date)
                  AND f.date <= COALESCE(?2, f.date)
                ORDER BY f.date, e.full_name
            """, nativeQuery = true)
    List<ProfitExpenseView> profitExpenseRows(
            LocalDate from,
            LocalDate to
    );
}