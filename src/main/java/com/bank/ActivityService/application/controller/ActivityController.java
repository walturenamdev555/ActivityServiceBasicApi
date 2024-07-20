package com.bank.ActivityService.application.controller;

import com.bank.ActivityService.api.RelationshipActivitiesApi;
import com.bank.ActivityService.model.ActivitySummary;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActivityController implements RelationshipActivitiesApi {
  @Override
  public ActivitySummary getActivitiesByRelationship(Long relationshipId) {
    return ActivitySummary.builder().relationshipId("RelationshipId " + relationshipId).build();
  }
}
