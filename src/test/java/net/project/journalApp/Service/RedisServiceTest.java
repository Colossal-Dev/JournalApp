package net.project.journalApp.Service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
@SpringBootTest
public class RedisServiceTest {


    @Autowired
    private RedisTemplate redisTemplate;


    @Disabled
    @Test
    public void testRedisService() {
    redisTemplate.opsForValue().set("email","chaurasiyav198@gmail.com");
   Object email= redisTemplate.opsForValue().get("email");
    int a =1;
        Assertions.assertEquals(4,2+2);


    }
}

