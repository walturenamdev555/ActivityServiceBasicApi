package com.bank.ActivityService.service.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Status {
  private StatusCode code;
  private String description;

  public StatusCode getCode() {
    return code;
  }

  public void setCode(StatusCode code) {
    this.code = code;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
