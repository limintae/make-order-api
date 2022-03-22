package com.github.prgrms.users.repository;

import com.github.prgrms.users.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
  Optional<User> findById(long id);
  Optional<User> findByEmail(String email);
}