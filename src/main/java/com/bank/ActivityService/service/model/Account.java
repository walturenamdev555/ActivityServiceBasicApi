package com.bank.ActivityService.service.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Account {
  private String accountId;
  private String accountNumber;
  private String accountName;
  private AccountSource source;
  private AccountAccountType accountType;
  private Boolean isAccountFullyLoaded;

  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public String getAccountName() {
    return accountName;
  }

  public void setAccountName(String accountName) {
    this.accountName = accountName;
  }

  public AccountSource getSource() {
    return source;
  }

  public void setSource(AccountSource source) {
    this.source = source;
  }

  public AccountAccountType getAccountType() {
    return accountType;
  }

  public void setAccountType(AccountAccountType accountType) {
    this.accountType = accountType;
  }

  public Boolean getIsAccountFullyLoaded() {
    return isAccountFullyLoaded;
  }

  public void setIsAccountFullyLoaded(Boolean isAccountFullyLoaded) {
    this.isAccountFullyLoaded = isAccountFullyLoaded;
  }
}
