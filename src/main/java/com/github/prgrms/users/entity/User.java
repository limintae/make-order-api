package com.github.prgrms.users.entity;

import static java.time.LocalDateTime.now;
import static org.apache.commons.lang3.ObjectUtils.defaultIfNull;

import com.github.prgrms.review.entity.Review;
import com.github.prgrms.security.token.Jwt;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "users")
@Entity
public class User implements Serializable {
  private static final long serialVersionUID = -9122027165506280295L;

  @Id
  @Column(name = "seq")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_seq")
  private Long id;

  @Column(name = "name", nullable = false,length = 20)
  private String name;

  @Column(name = "email", nullable = false, unique = true)
  private String email;

  @Column(name = "passwd", nullable = false)
  private String password;

  @Column(name = "login_count")
  private int loginCount;

  @Column(name = "last_login_at")
  @CreationTimestamp
  private LocalDateTime lastLoginAt;

  @Column(name = "create_at")
  private LocalDateTime createAt;

//  @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//  private List<Review> reviews;

  public static User of(String name, String email, String password){
    return new User(null, name, email, password, 0, null, null);
  }

  @Builder
  public User(
      Long id,
      String name,
      String email,
      String password,
      int loginCount,
      LocalDateTime lastLoginAt,
      LocalDateTime createAt) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.password = password;
    this.loginCount = loginCount;
    this.lastLoginAt = lastLoginAt;
    this.createAt = defaultIfNull(createAt, now());
  }

  public String newJwt(Jwt jwt, String[] roles) {
    Jwt.Claims claims = Jwt.Claims.of(id, name, roles);
    return jwt.create(claims);
  }

  public void login(PasswordEncoder passwordEncoder, String credentials) {
    if (!passwordEncoder.matches(credentials, password)) {
      throw new IllegalArgumentException("Bad credential");
    }
  }

  public void afterLoginSuccess() {
    loginCount++;
    lastLoginAt = now();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    User user = (User) o;
    return Objects.equals(id, user.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }


}
