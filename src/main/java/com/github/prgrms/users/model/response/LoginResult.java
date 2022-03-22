package com.github.prgrms.users.model.response;

import com.github.prgrms.users.entity.User;
import com.github.prgrms.users.model.dto.UserDto;
import lombok.Getter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Getter
public class LoginResult {

  private final String token;

  private final UserDto user;

  public LoginResult(String token, User user) {
    this.token = token;
    this.user = new UserDto(user);
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
        .append("token", token)
        .append("user", user)
        .toString();
  }

}