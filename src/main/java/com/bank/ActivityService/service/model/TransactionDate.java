package com.bank.ActivityService.service.model;

import lombok.Builder;
import lombok.Data;

/** Transaction Date */
@Data
@Builder
public class TransactionDate {

  private String date;

  private String description;

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
