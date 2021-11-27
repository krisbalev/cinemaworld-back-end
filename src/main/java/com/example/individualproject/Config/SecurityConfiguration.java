package com.example.individualproject.Config;

import com.example.individualproject.Filter.JWTAuthenticationFilter;
import com.example.individualproject.Filter.JWTAuthorizationFilter;
import com.example.individualproject.Service.AuthenticationUserDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AuthenticationUserDetailService authenticationUserDetailService;

    @Override protected void configure(HttpSecurity http) throws Exception {
        http.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues()).and().csrf().disable().authorizeRequests()
//        http.cors().and().csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.POST, AuthenticationConfigConstants.SIGN_UP_URL).permitAll()
                //ROLE BASED AUTHENTICATION START
                .antMatchers("/user/*").hasAnyAuthority("USER")
                .antMatchers("/movies/**").permitAll()
                .antMatchers("/movies/photo/**").permitAll()
//                .antMatchers("/account").permitAll() // HAS TO CHANGE ------------------
//            .antMatchers("/api/library/author/**").hasAnyAuthority("ADMIN")
//            .antMatchers("/api/library/member/**").hasAnyAuthority("ADMIN")
                //ROLE BASED AUTHENTICATION END
                .anyRequest().authenticated()
                .and()
                .addFilter(new JWTAuthenticationFilter(authenticationManager()))
                .addFilter(new JWTAuthorizationFilter(authenticationManager()))
                // this disables session creation on Spring Security
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(authenticationUserDetailService).passwordEncoder(bCryptPasswordEncoder);
    }
}