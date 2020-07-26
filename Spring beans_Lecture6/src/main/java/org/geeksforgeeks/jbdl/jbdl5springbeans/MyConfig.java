package org.geeksforgeeks.jbdl.jbdl5springbeans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Configuration
@Scope("prototype")
public class MyConfig {

    @Bean
    @Scope("prototype")
    public User getUser(){
        Person p = new Person();
        System.out.println(p);
        return new User();
    }

}
