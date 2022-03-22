package com.github.prgrms.users.model.request;

import javax.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginRequest {

  @NotBlank(message = "principal must be provided")
  private String principal;

  @NotBlank(message = "credentials must be provided")
  private String credentials;

  public LoginRequest(String principal, String credentials) {
    this.principal = principal;
    this.credentials = credentials;
  }

}