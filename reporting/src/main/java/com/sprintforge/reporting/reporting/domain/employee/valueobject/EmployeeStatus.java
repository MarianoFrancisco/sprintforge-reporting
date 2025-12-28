package com.sprintforge.reporting.reporting.domain.employee.valueobject;

public enum EmployeeStatus {
    ACTIVE,
    SUSPENDED,
    TERMINATED,
    UNKNOWN;

    public static EmployeeStatus from(String value) {
        if (value == null) return UNKNOWN;
        try {
            return EmployeeStatus.valueOf(value);
        } catch (IllegalArgumentException ex) {
            return UNKNOWN;
        }
    }
}
