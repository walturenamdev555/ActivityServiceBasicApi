package com.bank.ActivityService.service;


import com.bank.ActivityService.repo.UserRepo;
import com.bank.ActivityService.repo.entity.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

  @Override
  public UserProfile getUserProfileByEmailId(String emailId) {
    return Optional.ofNullable(userRepo.findOneByEmailByEmailIgnoreCase(emailId))
        .flatMap(user -> userRepo.findByUserId(user.get().getUserId()))
        .orElse(null);
  }
}
