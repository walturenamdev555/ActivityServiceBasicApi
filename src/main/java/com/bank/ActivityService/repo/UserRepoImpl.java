package com.bank.ActivityService.repo;


import com.bank.ActivityService.repo.entity.User;
import com.bank.ActivityService.repo.entity.UserProfile;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepoImpl implements UserRepo {
    @Override
    public Optional<User> findOneByEmailByEmailIgnoreCase(String emailId) {
        return Optional.of(new User());
    }

    @Override
    public Optional<UserProfile> findByUserId(String userId) {
        return Optional.empty();
    }
}
