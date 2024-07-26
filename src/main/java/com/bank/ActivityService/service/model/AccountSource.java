package com.bank.ActivityService.service.model;

public enum AccountSource {
    SBI_ACCOUNT("SBI_ACCOUNT"),
    BANK_ACCOUNT("BANK_ACCOUNT"),
    OUTSIDE_FIRM("OUTSIDE_FIRM"),
    CHECK("CHECK");

    private final String value;

    AccountSource(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public static AccountSource fromValue(String value) {
        for (AccountSource val : AccountSource.values()) {
            if (val.value.equals(value)) {
                return val;
            }
        }
        throw new IllegalArgumentException(value);
    }

}
