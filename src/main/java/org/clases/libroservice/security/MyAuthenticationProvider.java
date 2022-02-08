package org.clases.libroservice.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

/**
 * The type My authentication provider.
 */
@Component
public class MyAuthenticationProvider implements AuthenticationProvider {

  @Autowired
  @Qualifier("myUserDetailsService")
  private UserDetailsService myUserDetailService;

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {

    String name = authentication.getName();
    UsernamePasswordAuthenticationToken auth = null;
    if(name.equals("alice")|| name.equals("bernard")) {
      UserDetails userDetails = myUserDetailService.loadUserByUsername(name);
       auth =
          new UsernamePasswordAuthenticationToken(
              userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());


    }else{
      throw new BadCredentialsException("Error!!");
    }
    return auth;
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return authentication.equals(UsernamePasswordAuthenticationToken.class);
  }
}
