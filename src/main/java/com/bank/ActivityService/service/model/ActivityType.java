package com.bank.ActivityService.service.model;

public enum ActivityType {
  OUTSIDE_BACK("OUTSIDE_BACK"),
  CHECK("CHECK"),
  FIRM("FIRM"),
  INTERNAL("INTERNAL"),
  MOBILE_CHECK("MOBILE_CHECK");

  private final String value;

  ActivityType(String value) {
    this.value = value;
  }

  public String getValue() {
    return this.value;
  }

  public static ActivityType fromValue(String value) {
    for (ActivityType val : ActivityType.values()) {
      if (val.value.equals(value)) {
        return val;
      }
    }
    throw new IllegalArgumentException(value);
  }
}
