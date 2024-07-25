package com.bank.ActivityService.repo;

import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BankRepoImpl implements BankRepo {
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
