package com.bank.ActivityService.service.model;


public enum StatusCode {
    COMPLETED("COMPLETED"),
    REJECTED("REJECTED"),
    IN_PROGRESS("IN_PROGRESS"),
    FAILED("FAILED");

    private final String value;

    StatusCode(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public static StatusCode fromValue(String value) {
        for (StatusCode val : StatusCode.values()) {
            if (val.value.equals(value)) {
                return val;
            }
        }
        throw new IllegalArgumentException(value);
    }

}
