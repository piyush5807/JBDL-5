package org.geeksforgeeks.jbdl5.demospringsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class MyConfig extends WebSecurityConfigurerAdapter {

    // 3 things : authentication , authorization, passeord encoder

    @Autowired
    MyUserService userService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }

    // Q1 : Spring security intercepts every request coming on to it
    // Yes or No


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/student/**").hasAnyAuthority("student", "admin")
                .antMatchers("/faculty/**").hasAnyAuthority("faculty","admin")
                .antMatchers("/admin/**").hasAuthority("admin")
                .antMatchers("/**").permitAll()
                .and()
                .formLogin();
    }

    @Bean
    public PasswordEncoder getMyPassowrd(){
//        return new BCryptPasswordEncoder();
//        return NoOpPasswordEncoder.getInstance();

        return new BCryptPasswordEncoder();
    }
}
