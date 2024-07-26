package com.bank.ActivityService.service;

import com.bank.ActivityService.service.model.TransactionMapper;
import com.bank.ActivityService.service.model.Account;
import com.bank.ActivityService.service.model.AccountAccountType;
import com.bank.ActivityService.service.model.AccountSource;
import com.bank.ActivityService.service.model.Activity;
import com.bank.ActivityService.service.model.ActivitySummary;
import com.bank.ActivityService.service.model.ActivityType;
import com.bank.ActivityService.service.model.PartialError;
import com.bank.ActivityService.service.model.Status;
import com.bank.ActivityService.service.model.StatusCode;
import com.bank.ActivityService.service.model.TaxWitholding;
import com.bank.ActivityService.service.model.TransactionAmount;
import com.bank.ActivityService.service.model.TransactionDate;
import com.bank.ActivityService.repo.TransactionRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
  private final TransactionRepo transactionRepo;

  private final TransactionMapper transactionMapper = TransactionMapper.INSTANCE;

  private static final String ACTIVITY_ID_1111 = "act-1111";
  private static final String ACTIVITY_ID_2222 = "act-2222";
  private static final String ACTIVITY_ID_3333 = "act-3333";

  private static final String ACCOUNT_ID_1111 = "acc-1111";
  private static final String ACCOUNT_ID_2222 = "acc-2222";
  private static final String ACCOUNT_ID_3333 = "acc-3333";

  private static final String ACCOUNT_NUMBER_1111 = "No-1111";
  private static final String ACCOUNT_NUMBER_2222 = "No-2222";
  private static final String ACCOUNT_NUMBER_3333 = "No-3333";

  @Override
  public String getStatus(Integer accountId) {
    return transactionRepo.getStatus(accountId);
  }

  @Override
  public com.bank.ActivityService.model.ActivitySummary getActivities(String relationshipId) {
    return Optional.ofNullable(getActivityByRelationshipId(relationshipId))
        .map(map -> transactionMapper.map(map.get(relationshipId)))
        .orElse(
            com.bank.ActivityService.model
                .ActivitySummary
                .builder()
                .relationshipId(relationshipId)
                .error(
                    com.bank.ActivityService.model
                        .PartialError
                        .builder()
                        .failedType("FULL_FAILURE")
                        .description("All type of activities failed")
                        .build())
                .build());
  }

  private Map<String, ActivitySummary> getActivityByRelationshipId(String relationshipId) {
    return Map.of(
        "1111",
        ActivitySummary.builder()
            .relationshipId(relationshipId)
            .error(
                PartialError.builder()
                    .failedType("CHECK")
                    .description(
                        "Checks call failed while loading data for relationshipId: "
                            + relationshipId)
                    .build())
            .activities(
                List.of(
                    Activity.builder()
                        .activityId(ACTIVITY_ID_1111)
                        .type(ActivityType.OUTSIDE_BACK)
                        .from(
                            getAccount(
                                ACCOUNT_ID_1111, ACCOUNT_NUMBER_1111, AccountSource.BANK_ACCOUNT))
                        .to(
                            getAccount(
                                ACCOUNT_ID_2222, ACCOUNT_NUMBER_3333, AccountSource.SBI_ACCOUNT))
                        .transactionDate(getTransactionDate("2022-04-06"))
                        .transactionAmount(getTransactionAmount(500.0, 200.0))
                        .statuses(getStatus(StatusCode.COMPLETED))
                        .build(),
                    Activity.builder()
                        .activityId(ACTIVITY_ID_2222)
                        .type(ActivityType.INTERNAL)
                        .from(
                            getAccount(
                                ACCOUNT_ID_1111, ACCOUNT_NUMBER_1111, AccountSource.SBI_ACCOUNT))
                        .to(
                            getAccount(
                                ACCOUNT_ID_2222, ACCOUNT_NUMBER_3333, AccountSource.BANK_ACCOUNT))
                        .transactionDate(getTransactionDate("2022-04-24"))
                        .transactionAmount(getTransactionAmount(220.0, 210.0))
                        .statuses(getStatus(StatusCode.IN_PROGRESS))
                        .build()))
            .build(),
        "2222",
        ActivitySummary.builder()
            .relationshipId(relationshipId)
            .error(
                PartialError.builder()
                    .failedType("CHECK")
                    .description(
                        "Checks call failed while loading data for relationshipId: "
                            + relationshipId)
                    .build())
            .activities(
                List.of(
                    Activity.builder()
                        .activityId(ACTIVITY_ID_1111)
                        .type(ActivityType.OUTSIDE_BACK)
                        .from(
                            getAccount(
                                ACCOUNT_ID_1111, ACCOUNT_NUMBER_1111, AccountSource.BANK_ACCOUNT))
                        .to(
                            getAccount(
                                ACCOUNT_ID_1111, ACCOUNT_NUMBER_2222, AccountSource.SBI_ACCOUNT))
                        .transactionDate(getTransactionDate("2022-04-06"))
                        .transactionAmount(getTransactionAmount(500.0, 200.0))
                        .statuses(getStatus(StatusCode.COMPLETED))
                        .build(),
                    Activity.builder()
                        .activityId(ACTIVITY_ID_2222)
                        .type(ActivityType.INTERNAL)
                        .from(
                            getAccount(
                                ACCOUNT_ID_1111, ACCOUNT_NUMBER_1111, AccountSource.SBI_ACCOUNT))
                        .to(
                            getAccount(
                                ACCOUNT_ID_2222, ACCOUNT_NUMBER_3333, AccountSource.BANK_ACCOUNT))
                        .transactionDate(getTransactionDate("2021-04-24"))
                        .transactionAmount(getTransactionAmount(220.0, 210.0))
                        .statuses(getStatus(StatusCode.IN_PROGRESS))
                        .build(),
                    Activity.builder()
                        .activityId(ACTIVITY_ID_3333)
                        .type(ActivityType.INTERNAL)
                        .from(
                            getAccount(
                                ACCOUNT_ID_1111, ACCOUNT_NUMBER_2222, AccountSource.SBI_ACCOUNT))
                        .to(
                            getAccount(
                                ACCOUNT_ID_3333, ACCOUNT_NUMBER_1111, AccountSource.BANK_ACCOUNT))
                        .transactionDate(getTransactionDate("2024-04-24"))
                        .transactionAmount(getTransactionAmount(120.0, 300.0))
                        .statuses(getStatus(StatusCode.COMPLETED))
                        .build()))
            .build());
  }

  private TransactionAmount getTransactionAmount(Double netAmount, Double grossAmount) {
    return TransactionAmount.builder()
        .netAmount(netAmount)
        .grossAmount(grossAmount)
        .fees(Double.MIN_VALUE)
        .tax(TaxWitholding.builder().build())
        .build();
  }

  private Account getAccount(String accountId, String accountNumber, AccountSource source) {
    return Account.builder()
        .accountId(accountId)
        .accountName("Bank account " + accountId)
        .accountNumber(accountNumber)
        .accountType(AccountAccountType.CASH)
        .source(source)
        .isAccountFullyLoaded(true)
        .build();
  }

  private TransactionDate getTransactionDate(String date) {
    return TransactionDate.builder().date(date).description("Transaction Initiated Date").build();
  }

  private Status getStatus(StatusCode code) {
    return Status.builder().code(code).description("Transaction status").build();
  }
}
