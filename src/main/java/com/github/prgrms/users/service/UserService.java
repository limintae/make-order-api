package com.github.prgrms.users.service;

import com.github.prgrms.errors.*;
import com.github.prgrms.users.repository.UserRepository;
import com.github.prgrms.users.entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.google.common.base.Preconditions.checkNotNull;

@Service
public class UserService {

  private final PasswordEncoder passwordEncoder;

  private final UserRepository userRepository;

  public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
    this.passwordEncoder = passwordEncoder;
    this.userRepository = userRepository;
  }

  @Transactional
  public User login(String email, String password) {
    checkNotNull(password, "password must be provided");
    User user = findByEmail(email)
        .orElseThrow(() -> new NotFoundException("Could not found user for " + email));
    user.login(passwordEncoder, password);
    user.afterLoginSuccess();
    userRepository.save(user);
    return user;
  }

  @Transactional(readOnly = true)
  public Optional<User> findById(Long userId) {
    checkNotNull(userId, "userId must be provided");

    return userRepository.findById(userId);
  }

  @Transactional(readOnly = true)
  public Optional<User> findByEmail(String email) {
    checkNotNull(email, "email must be provided");

    return userRepository.findByEmail(email);
  }

}