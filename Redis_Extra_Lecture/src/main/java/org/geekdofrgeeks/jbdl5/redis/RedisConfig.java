package org.geekdofrgeeks.jbdl5.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

@Configuration
public class RedisConfig {

    @Bean
    Jedis jedis(){
        Jedis jedis = new Jedis("redis-12397.c240.us-east-1-3.ec2.cloud.redislabs.com", 12397);
        jedis.auth("h78Nf1x838EVbFSgFzZc7OmyZ9hSwxRq");
        return jedis;
    }
}
