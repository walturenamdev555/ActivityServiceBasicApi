package com.bank.ActivityService.service;

import com.bank.ActivityService.model.ActivitySummary;

public interface TransactionService {
    String getStatus(Integer accountId);

    ActivitySummary getActivities(String relationshipId);
}
