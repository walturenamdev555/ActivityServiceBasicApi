package com.bank.ActivityService.service.model;

import lombok.Builder;
import lombok.Data;

/** Activity object for all transfer types */
@Data
@Builder
public class Activity {
  private String activityId;
  private ActivityType type;
  private Status statuses;
  private Account from;
  private Account to;

  private TransactionAmount transactionAmount;

  private TransactionDate transactionDate;

  public String getActivityId() {
    return activityId;
  }

  public void setActivityId(String activityId) {
    this.activityId = activityId;
  }

  public ActivityType getType() {
    return type;
  }

  public void setType(ActivityType type) {
    this.type = type;
  }

  public Status getStatuses() {
    return statuses;
  }

  public void setStatuses(Status statuses) {
    this.statuses = statuses;
  }

  public Account getFrom() {
    return from;
  }

  public void setFrom(Account from) {
    this.from = from;
  }

  public Account getTo() {
    return to;
  }

  public void setTo(Account to) {
    this.to = to;
  }

  public TransactionAmount getTransactionAmount() {
    return transactionAmount;
  }

  public void setTransactionAmount(TransactionAmount transactionAmount) {
    this.transactionAmount = transactionAmount;
  }

  public TransactionDate getTransactionDate() {
    return transactionDate;
  }

  public void setTransactionDate(TransactionDate transactionDate) {
    this.transactionDate = transactionDate;
  }
}
