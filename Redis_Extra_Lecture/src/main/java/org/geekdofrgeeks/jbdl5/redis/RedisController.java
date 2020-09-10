package org.geekdofrgeeks.jbdl5.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
public class RedisController {

    @Autowired
    Jedis jedis;

    @GetMapping("/getValue")
    public String getValue(@RequestParam("key") String key){
        return jedis.get(key);
    }

    @PostMapping("/setKey")
    public String setKey(@RequestParam("key") String key, @RequestParam("value") String value){
        return jedis.set(key, value);
    }

    @PostMapping("/setKeyWithExpiry")
    public String setKey(@RequestParam("key") String key, @RequestParam("value") String value, @RequestParam("time") int expiry){
        return jedis.setex(key, expiry, value);
    }

    @PostMapping("/add_left_list")
    public Long addToLeftOfList(@RequestParam("key") String key, @RequestParam("value") String value){
        return jedis.lpush(key, value);
    }

    @PostMapping("/add_right_list")
    public Long addToRightOfList(@RequestParam("key") String key, @RequestParam("value") String value){
        return jedis.rpush(key, value);
    }

    @PostMapping("/set_hash_field")
    public String addHashField(@RequestParam("key") String key, @RequestParam("field") String field, @RequestParam("val") String val){
        Map<String, String> fieldMap = new HashMap<>();
        fieldMap.put(field, val);
        return jedis.hmset(key, fieldMap);
    }

    @GetMapping("/get_hash_fields")
    public Map<String, String> getHashFields(@RequestParam("key") String key){
        return jedis.hgetAll(key);
    }

    @GetMapping("/get_all_keys")
    public Set<String> getAllKeys(){
        return jedis.keys("*");
    }
}
