package org.geeksforgeeks.jbdl5.demospringsecurity;

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


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("piyush")
                .password("piyush1234")
                .authorities("STUDENT")
                .and()
                .withUser("karan")
                .password("karan1234")
                .authorities("FACULTY")
                .and()
                .withUser("Rahul")
                .password("rahul1234")
                .authorities("ADMIN");
    }

    // Q1 : Spring security intercepts every request coming on to it
    // Yes or No


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/student/**").hasAnyAuthority("STUDENT", "ADMIN")
                .antMatchers("/faculty/**").hasAnyAuthority("FACULTY","ADMIN")
                .antMatchers("/admin/**").hasAuthority("ADMIN")
                .antMatchers("/**").permitAll()
                .and()
                .formLogin();
    }

    @Bean
    public PasswordEncoder getMyPassowrd(){
//        return new BCryptPasswordEncoder();
        return NoOpPasswordEncoder.getInstance();
    }
}
