package com.jason.springbootweb.controller;

import com.jason.springbootweb.Base.BaseController;
import com.jason.springbootweb.dao.mapper.UserMapper;
import com.jason.springbootweb.dao.pojo.User;
import com.jason.springbootweb.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/user")
public class UserController  extends BaseController {
    //依赖注入
    @Autowired
    private UserMapper userMapper;

    @ResponseBody
    @RequestMapping(value = "/query")
    public ResponseVo query(String name) {
        //调用dao层
        responseVo.setSuccess(true);
        responseVo.setResultObject(userMapper.selectUserbyName(name));
        return responseVo;
    }

    @RequestMapping(value="/insert")
    public Integer insert(User user){
        return userMapper.insertUser(user);
    }

}
