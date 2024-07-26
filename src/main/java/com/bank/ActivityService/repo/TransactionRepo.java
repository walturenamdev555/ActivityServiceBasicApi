package com.bank.ActivityService.repo;

import com.bank.ActivityService.model.ActivitySummary;

public interface TransactionRepo {
    ActivitySummary getActivities(String relationshipId);

    String getStatus(Integer accountId);

    String test();
}
