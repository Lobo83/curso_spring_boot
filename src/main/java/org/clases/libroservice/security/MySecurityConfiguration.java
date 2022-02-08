package org.clases.libroservice.security;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * The type My security configuration.
 */
@Configuration
@EnableWebSecurity
public class MySecurityConfiguration extends WebSecurityConfigurerAdapter {
  @Autowired
  private MyAuthenticationProvider myAuthenticationProvider;

  @Autowired
  private MyAuthenticationEntryPoint myAuthenticationEntryPoint;

  @Override
  protected void configure(HttpSecurity http) throws Exception {

    http.csrf().disable().headers().frameOptions().sameOrigin().and().exceptionHandling().authenticationEntryPoint(
        myAuthenticationEntryPoint).and()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests().antMatchers("/h2-console").permitAll()
        .antMatchers("/libros/**").hasAnyRole("ADMIN","USER");

    http.addFilterBefore(myFilter(authenticationManager()), UsernamePasswordAuthenticationFilter.class);
  }

  @Bean
  public OncePerRequestFilter myFilter(AuthenticationManager authenticationManager){
    return new MyFilter(authenticationManager);
  }
  @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
  @Override
  protected AuthenticationManager authenticationManager()  {
    return new ProviderManager(Arrays.asList((AuthenticationProvider) myAuthenticationProvider));
  }

}
