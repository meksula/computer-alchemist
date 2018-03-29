package com.computeralchemist.config;

import com.computeralchemist.security.AuthenticationSuccessHandlerImpl;
import com.computeralchemist.security.EntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.ForwardAuthenticationFailureHandler;

/**
 * @Author
 * Karol Meksuła
 * 28-03-2018
 * */

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = "com.computeralchemist.security")
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private UserDetailsService userDetailsService;
    private EntryPoint entryPoint;

    @Autowired
    public void setEntryPoint(EntryPoint entryPoint, UserDetailsService userDetailsService) {
        this.entryPoint = entryPoint;
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public AuthenticationSuccessHandlerImpl authenticationSuccessHandlerImpl() {
        return new AuthenticationSuccessHandlerImpl();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //TODO failure handler

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.exceptionHandling().authenticationEntryPoint(entryPoint)
                .and()
                .authorizeRequests().antMatchers("/api/user/**").authenticated()
                .and().formLogin().successHandler(authenticationSuccessHandlerImpl())
                .failureHandler(new ForwardAuthenticationFailureHandler("/api/user/denied"))
                .and().authorizeRequests()
                .antMatchers(HttpMethod.POST, "/api/user").permitAll()
                .and().logout();
    }
}
