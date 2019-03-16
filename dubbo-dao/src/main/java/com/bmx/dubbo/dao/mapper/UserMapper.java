package com.bmx.dubbo.dao.mapper;


import com.bmx.dubbo.dao.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *
 */
@Mapper
public interface UserMapper {

    List<User> findAll();

    User findUserById(Integer id);
}
