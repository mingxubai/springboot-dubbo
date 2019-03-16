package com.bmx.api.service;

import com.bmx.dubbo.dao.pojo.User;

import java.io.IOException;
import java.util.List;

public interface UserService {
    List<User> findAll();

    User findUserById(Integer id) throws IOException;
}
