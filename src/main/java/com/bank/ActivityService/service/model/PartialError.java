package com.bank.ActivityService.service.model;

import lombok.Builder;
import lombok.Data;

/** Shows the failed call and treire error response */
@Data
@Builder
public class PartialError {
  private String failedType;

  private String description;

  public String getFailedType() {
    return failedType;
  }

  public void setFailedType(String failedType) {
    this.failedType = failedType;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
