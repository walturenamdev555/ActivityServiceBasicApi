package com.bank.ActivityService.repo;


import com.bank.ActivityService.repo.entity.User;
import com.bank.ActivityService.repo.entity.UserProfile;

import java.util.Optional;

public interface UserRepo {
    Optional<User> findOneByEmailByEmailIgnoreCase(String emailId);

    Optional<UserProfile> findByUserId(String userId);
}
