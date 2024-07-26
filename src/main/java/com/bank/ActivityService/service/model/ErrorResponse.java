package com.bank.ActivityService.service.model;

import java.util.List;
import lombok.Builder;
import lombok.Data;

/** Error response */
@Data
@Builder
public class ErrorResponse {

  private List<Error> errors;

  public List<Error> getErrors() {
    return errors;
  }

  public void setErrors(List<Error> errors) {
    this.errors = errors;
  }
}
