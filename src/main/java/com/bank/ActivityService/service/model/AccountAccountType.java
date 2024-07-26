package com.bank.ActivityService.service.model;

public enum AccountAccountType {
  CASH("CASH"),
  LOAN("LOAN"),
  SECURITIES("SECURITIES");

  private final String value;

  AccountAccountType(String value) {
    this.value = value;
  }

  public String getValue() {
    return this.value;
  }

  public static AccountAccountType fromValue(String value) {
    for (AccountAccountType val : AccountAccountType.values()) {
      if (val.value.equals(value)) {
        return val;
      }
    }
    throw new IllegalArgumentException(value);
  }
}
