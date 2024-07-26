package com.bank.ActivityService.service.model;

import java.util.List;
import lombok.Builder;
import lombok.Data;

/**
 * Error object
 */
@Data
@Builder
public class Error {

    private Integer code;
    private String description;
    private List<String> fieldNames;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getFieldNames() {
        return fieldNames;
    }

    public void setFieldNames(List<String> fieldNames) {
        this.fieldNames = fieldNames;
    }

}
