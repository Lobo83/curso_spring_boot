package org.clases.libroservice.security;

import java.util.ArrayList;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * The type My user details service.
 */
@Service("myUserDetailsService")
public class MyUserDetailsService implements UserDetailsService {

  @Override
  public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
    UserDetails userDetails = new MyUserDetails();
    List<GrantedAuthority> authorityList = new ArrayList<>();
    GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_ADMIN");
    authorityList.add(authority);
    if (userName.equals("alice")) {
      ((MyUserDetails) userDetails).setUsername("alice");
      ((MyUserDetails) userDetails).setPassword("123");
      ((MyUserDetails) userDetails).setAuthorities(authorityList);
    }
    if (userName.equals("bernard")) {
      ((MyUserDetails) userDetails).setUsername("bernard");
      ((MyUserDetails) userDetails).setPassword("123");
     // ((MyUserDetails) userDetails).setAuthorities(authorityList);
    }
    return userDetails;
  }
}
