package com.example.ex02_hyunju_2227572.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        String[] resources = new String[]{
                "/", "/home","/pictureCheckCode","/include/**",
                "/css/**","/icons/**","/images/**","/js/**","/layer/**"
        };

        http.authorizeRequests()
                .antMatchers(resources).permitAll()
                .antMatchers("/users").authenticated().anyRequest().permitAll()
                .and()
                .formLogin()
                .usernameParameter("email")
                .defaultSuccessUrl("/users")
                .permitAll()
                .and().logout().logoutSuccessUrl("/").permitAll();
        http
                .authorizeRequests()
                .mvcMatchers("/","/css/**","/scripts/**","/plugin/**","/fonts/**")
                .permitAll();

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }


}
