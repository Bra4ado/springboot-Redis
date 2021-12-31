package com.dragonzhu.springbootredis;

import com.dragonzhu.springbootredis.Entiy.User;
import com.dragonzhu.springbootredis.Utils.RedisOfDatabaseOneUtil;
import com.dragonzhu.springbootredis.Utils.RedisOfDatabaseTwoUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

@SpringBootTest
class SpringbootRedisApplicationTests {
    @Resource
    private RedisTemplate<String, Object> stringRedisTemplate1;

    @Autowired
    private RedisOfDatabaseOneUtil redisOfDatabaseOneUtil;
    @Autowired
    private RedisOfDatabaseTwoUtil redisOfDatabaseTwoUtil;
    @Test
    void getName(){
        stringRedisTemplate1.opsForValue().set("name","连接成功!");
        System.out.println(stringRedisTemplate1.opsForValue().get("name"));
    }

    @Test
    void setObject(){
        User user = new User();
        user.setName("UserTest2");
        user.setAge(23);
        user.setHigh(172);
        redisOfDatabaseTwoUtil.set("UserTest2",user);
        System.out.println(redisOfDatabaseTwoUtil.get("UserTest2"));
    }

}
