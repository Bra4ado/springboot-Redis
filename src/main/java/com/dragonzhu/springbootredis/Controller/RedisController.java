package com.dragonzhu.springbootredis.Controller;

import com.dragonzhu.springbootredis.Utils.RedisOfDatabaseOneUtil;
import com.dragonzhu.springbootredis.Utils.RedisOfDatabaseTwoUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
/**
 * @author zxl
 * @create 2021/12/30 17:03
 */
@Slf4j
@RestController
@RequestMapping("/Redis")
public class RedisController {
    @Autowired
    private RedisOfDatabaseOneUtil redisOfDatabaseOneUtil;
    @Autowired
    private RedisOfDatabaseTwoUtil redisOfDatabaseTwoUtil;

    @GetMapping("/getName")
    public Map<String,Object> getName(@RequestParam Map<String,Object> paramsMap) {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("name", redisOfDatabaseOneUtil.get(paramsMap.get("name").toString()));
        return resultMap;
    }
    @GetMapping("/setName")
    public Object setName(@RequestParam Map<String,Object> paramsMap){
        String nameKey = paramsMap.get("nameKey").toString();
        String nameValue = paramsMap.get("nameValue").toString();
        redisOfDatabaseOneUtil.set(nameKey,nameValue);
        return"加入成功!";
    }
    @GetMapping("/setNameToTwo")
    public Object setNameToTwo(@RequestParam Map<String,Object> paramsMap){
        String nameKey = paramsMap.get("nameKey").toString();
        String nameValue = paramsMap.get("nameValue").toString();
        redisOfDatabaseTwoUtil.set(nameKey,nameValue);
        return"加入成功!";
    }
}




