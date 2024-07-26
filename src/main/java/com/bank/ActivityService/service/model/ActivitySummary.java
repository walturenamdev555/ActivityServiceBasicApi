package com.bank.ActivityService.service.model;

import java.util.List;
import lombok.Builder;
import lombok.Data;

/**
 * This is Activity response
 */
@Data
@Builder
public class ActivitySummary {

    private PartialError error;

    private String relationshipId;

    private List<Activity> activities;

    public PartialError getError() {
        return error;
    }

    public void setError(PartialError error) {
        this.error = error;
    }

    public String getRelationshipId() {
        return relationshipId;
    }

    public void setRelationshipId(String relationshipId) {
        this.relationshipId = relationshipId;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

}
