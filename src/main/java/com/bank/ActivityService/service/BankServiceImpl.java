package com.bank.ActivityService.service;

import com.bank.ActivityService.repo.BankRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class BankServiceImpl implements BankService {
    private final BankRepo bankRepo;

    @Override
    public String getStatus(Integer accountId) {
        return bankRepo.getStatus(accountId);
    }
}
