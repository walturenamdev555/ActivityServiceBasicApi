package com.bank.ActivityService.service.model;

import lombok.Builder;
import lombok.Data;

/** Shows the diffrent type of amount included in trasaction */
@Data
@Builder
public class TransactionAmount {
  private Double netAmount;

  private Double grossAmount;

  private Double fees;

  private TaxWitholding tax;

  public Double getNetAmount() {
    return netAmount;
  }

  public void setNetAmount(Double netAmount) {
    this.netAmount = netAmount;
  }

  public Double getGrossAmount() {
    return grossAmount;
  }

  public void setGrossAmount(Double grossAmount) {
    this.grossAmount = grossAmount;
  }

  public Double getFees() {
    return fees;
  }

  public void setFees(Double fees) {
    this.fees = fees;
  }

  public TaxWitholding getTax() {
    return tax;
  }

  public void setTax(TaxWitholding tax) {
    this.tax = tax;
  }
}
