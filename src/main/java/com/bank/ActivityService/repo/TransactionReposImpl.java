package com.bank.ActivityService.repo;

import com.bank.ActivityService.model.ActivitySummary;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TransactionReposImpl implements TransactionRepo {
    RestTemplate restTemplate;
    String url = "http://localhost:8081/getActivities/{relationshipId}";

  @Override
  public ActivitySummary getActivities(String relationshipId) {
      return restTemplate.getForObject(
        url, ActivitySummary.class, Map.of("relationshipId", relationshipId));
  }

    @Override
    public String getStatus(Integer accountId) {
        test();
        return Optional.ofNullable(accountId).map(id -> "SUCCESS").orElse("ERROR");
    }

    @Override
    public String test() {
        return "Testing...";
    }
}
