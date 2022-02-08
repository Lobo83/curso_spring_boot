package org.clases.libroservice.security;

import java.io.IOException;
import java.util.Base64;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

@AllArgsConstructor
@Slf4j
public class MyFilter extends OncePerRequestFilter {

  private AuthenticationManager authenticationManager;

  @Override
  protected void doFilterInternal(HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse, FilterChain filterChain)
      throws ServletException, IOException {

    String auth=httpServletRequest.getHeader("Authorization");

    if(null!=auth && auth.startsWith("Basic ")) {

      auth = new String(Base64.getDecoder().decode(auth.substring(6)));
      String[] credentials = auth.split(":");
      Authentication authentication = new UsernamePasswordAuthenticationToken(credentials[0],
          credentials[1]);
      try {
        Authentication userAuth=authenticationManager.authenticate(authentication);
        SecurityContextHolder.getContext().setAuthentication(userAuth);
      }catch (AuthenticationException e){
        SecurityContextHolder.clearContext();
        log.error("Error autenticando usuario ",e);
      }
    }

    filterChain.doFilter(httpServletRequest, httpServletResponse);
  }
}
