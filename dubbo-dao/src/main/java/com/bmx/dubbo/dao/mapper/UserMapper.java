package com.bmx.dubbo.dao.mapper;


import com.bmx.dubbo.dao.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 *
 */
@Mapper
public interface UserMapper {

    List<User> findAll();

    @Select("select * from user where id = #{id}")
    User findUserById(Integer id);
}
