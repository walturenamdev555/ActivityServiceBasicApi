package com.bank.ActivityService.service;

import com.bank.ActivityService.repo.entity.UserProfile;

public interface UserService {
    UserProfile getUserProfileByEmailId(String emailId);
}
