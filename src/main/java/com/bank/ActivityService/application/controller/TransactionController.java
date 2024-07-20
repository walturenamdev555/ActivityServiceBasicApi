package com.bank.ActivityService.application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    @GetMapping("/get")
    public String success() {
        return "success";
    }

    @GetMapping("/save")
    public String saveAccounts() {
        return "Currently this functionality is under development";
    }
}
