package com.bmx.dubbo.consumer.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.bmx.api.service.UserService;
import com.bmx.dubbo.dao.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Api(value="用户controller",tags={"用户操作接口"})
@RestController
@RequestMapping("user")
public class UserController {

    @Reference
    private UserService userService;


    @ApiOperation(value="获取用户列表", notes="获取用户列表")
    @RequestMapping(value = "findAll", method = RequestMethod.GET)
    public List<User> findAll(){
        return userService.findAll();
    }

    @ApiOperation(value="获取用户详细信息", notes="根据id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", dataType = "Integer", paramType = "path")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User findUserById(@PathVariable(value = "id") Integer id) throws IOException {

        return userService.findUserById(id);
    }
}