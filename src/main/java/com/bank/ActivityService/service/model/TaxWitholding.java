package com.bank.ActivityService.service.model;

import lombok.Builder;
import lombok.Data;

/** Show all applied tax */
@Data
@Builder
public class TaxWitholding {

  private Double centralTax;

  private Double stateTax;

  public Double getCentralTax() {
    return centralTax;
  }

  public void setCentralTax(Double centralTax) {
    this.centralTax = centralTax;
  }

  public Double getStateTax() {
    return stateTax;
  }

  public void setStateTax(Double stateTax) {
    this.stateTax = stateTax;
  }
}
