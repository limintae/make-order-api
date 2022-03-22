package com.github.prgrms.security.token;

import com.github.prgrms.errors.NotFoundException;
import com.github.prgrms.security.Role;
import com.github.prgrms.users.entity.User;
import com.github.prgrms.users.service.UserService;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static org.apache.commons.lang3.ClassUtils.isAssignable;
import static org.springframework.security.core.authority.AuthorityUtils.createAuthorityList;

public class JwtAuthenticationProvider implements AuthenticationProvider {

  private final UserService userService;

  public JwtAuthenticationProvider(UserService userService) {
    this.userService = userService;
  }

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    JwtAuthenticationToken authenticationToken = (JwtAuthenticationToken) authentication;
    return processUserAuthentication(
        String.valueOf(authenticationToken.getPrincipal()),
        authenticationToken.getCredentials()
    );
  }

  private Authentication processUserAuthentication(String email, String password) {
    try {
      User user = userService.login(email, password);
      JwtAuthenticationToken authenticated =
          new JwtAuthenticationToken(
              new JwtAuthentication(user.getId(), user.getName()),
              null,
              createAuthorityList(Role.USER.value())
          );
      authenticated.setDetails(user);
      return authenticated;
    } catch (NotFoundException e) {
      throw new UsernameNotFoundException(e.getMessage());
    } catch (IllegalArgumentException e) {
      throw new BadCredentialsException(e.getMessage());
    } catch (DataAccessException e) {
      throw new AuthenticationServiceException(e.getMessage(), e);
    }
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return isAssignable(JwtAuthenticationToken.class, authentication);
  }

}