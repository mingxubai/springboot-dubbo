package com.bmx.dubbo.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.bmx.api.service.UserService;
import com.bmx.dubbo.dao.mapper.UserMapper;
import com.bmx.dubbo.dao.pojo.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import util.IdWorker;

import java.io.IOException;
import java.util.List;

/**
 * 用户管理
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * id生成工具
     */
    @Autowired
    private IdWorker idWorker;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public List<User> findAll() {

        return userMapper.findAll();
    }

    @Override
    public User findUserById(Integer id) throws IOException {
        //先查redis中是否存在user
        String json = redisTemplate.opsForValue().get("user:" + id);

        User user = null;
        if (!StringUtils.isEmpty(json)) {
            user = objectMapper.readValue(json, User.class);
        } else {
            user = userMapper.findUserById(id);
            //存入缓存
            redisTemplate.opsForValue().set("user:"+id, objectMapper.writeValueAsString(user));
        }
        return user;
    }

}
