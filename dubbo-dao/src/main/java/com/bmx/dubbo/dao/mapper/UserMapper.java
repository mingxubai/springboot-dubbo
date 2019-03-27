package com.bmx.dubbo.dao.mapper;


import com.bmx.dubbo.dao.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 用户mapper接口
 */
@Mapper
public interface UserMapper {

    /**
     * 查询用户列表
     * @return List<User>
     */
    List<User> findAll();

    /**
     * 根据id查询用户详情
     * @param id
     * @return User
     */
    @Select("select * from user where id = #{id}")
    User findUserById(Integer id);
}
