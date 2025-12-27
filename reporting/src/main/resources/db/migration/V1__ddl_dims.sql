CREATE TABLE dim_project
(
    project_id  UUID PRIMARY KEY,
    project_key VARCHAR(10)  NOT NULL UNIQUE,
    name        VARCHAR(50)  NOT NULL UNIQUE,
    client      VARCHAR(100) NOT NULL,
    area        VARCHAR(80)  NOT NULL,
    is_closed   BOOLEAN      NOT NULL,
    is_deleted  BOOLEAN      NOT NULL
);

CREATE INDEX idx_dim_project_client_area
    ON dim_project (client, area);

CREATE TABLE dim_employee
(
    employee_id UUID PRIMARY KEY,
    full_name   VARCHAR(201) NOT NULL,
    status      VARCHAR(20)  NOT NULL
);

CREATE INDEX idx_dim_employee_status
    ON dim_employee (status);
