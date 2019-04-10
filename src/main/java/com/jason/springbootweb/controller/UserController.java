package com.jason.springbootweb.controller;

import com.jason.springbootweb.dao.mapper.UserMapper;
import com.jason.springbootweb.dao.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    //依赖注入
    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "/query")
    public User query(String name) {
        //调用dao层
        return userMapper.selectUserbyName(name);
    }

    @RequestMapping(value="/insert")
    public Integer insert(User user){
        return userMapper.insertUser(user);
    }

}
