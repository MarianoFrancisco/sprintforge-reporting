CREATE TABLE fact_project_payment
(
    payment_id UUID PRIMARY KEY,
    project_id UUID           NOT NULL
        REFERENCES dim_project (project_id)
            ON DELETE CASCADE,
    date       DATE           NOT NULL,
    amount     NUMERIC(12, 2) NOT NULL,
    method     VARCHAR(20)    NOT NULL
);

CREATE INDEX idx_fact_project_payment_project_date
    ON fact_project_payment (project_id, date);

CREATE INDEX idx_fact_project_payment_date
    ON fact_project_payment (date);

CREATE TABLE fact_employee_payment
(
    payment_id  UUID PRIMARY KEY,
    employee_id UUID           NOT NULL
        REFERENCES dim_employee (employee_id)
            ON DELETE CASCADE,
    date        DATE           NOT NULL,
    base_salary NUMERIC(10, 2) NOT NULL,
    bonus       NUMERIC(10, 2) NOT NULL DEFAULT 0.00,
    deduction   NUMERIC(10, 2) NOT NULL DEFAULT 0.00,
    total       NUMERIC(10, 2) NOT NULL
);

CREATE INDEX idx_fact_employee_payment_employee_date
    ON fact_employee_payment (employee_id, date);

CREATE INDEX idx_fact_employee_payment_date
    ON fact_employee_payment (date);
