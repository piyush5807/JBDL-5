package org.geeksforgeeks.jbdl.jbdl5springbeans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Configuration

@Component
public class MyConfig {

    @Bean
    @Scope("prototype")
    public User getUser(){
        return new User();
    }
}
