package com.bmx.api.service;

import com.bmx.dubbo.dao.pojo.User;

import java.io.IOException;
import java.util.List;

/**
 * 用户逻辑处理接口
 */
public interface UserService {

    List<User> findAll();

    User findUserById(Integer id) throws IOException;
}
