package com.bank.ActivityService.application.controller;

import com.bank.ActivityService.api.RelationshipActivitiesApi;
import com.bank.ActivityService.model.ActivitySummary;
import com.bank.ActivityService.model.PartialError;
import com.bank.ActivityService.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ActivityController implements RelationshipActivitiesApi {
  private final TransactionService transactionService;

  @Override
  public ActivitySummary getActivitiesByRelationship(Long relationshipId) {
    return Optional.ofNullable(relationshipId)
        .map(String::valueOf)
        .map(transactionService::getActivities)
        .orElse(
            ActivitySummary.builder()
                .error(
                    PartialError.builder()
                        .failedType("404")
                        .description("Invalid relationshipId")
                        .build())
                .build());
  }
}
