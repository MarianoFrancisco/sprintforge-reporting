package com.sprintforge.reporting.reporting.domain.finance.valueobject;

public enum PaymentMethod {
    CASH,
    TRANSFER,
    CARD,
    UNKNOWN;

    public static PaymentMethod from(String value) {
        if (value == null) return UNKNOWN;
        try {
            return PaymentMethod.valueOf(value);
        } catch (IllegalArgumentException ex) {
            return UNKNOWN;
        }
    }
}
