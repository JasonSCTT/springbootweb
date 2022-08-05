package com.jason.springbootweb.service;

import com.jason.springbootweb.dao.mapper.LoginUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author jason
 * @Date 2020-01-22
 */
@Service
public class UserService {


    @Autowired
    private LoginUserMapper loginUserMapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void insertUser1(){
        Map params1=new HashMap<>();
        params1.put("username","shencheng1");
        params1.put("password","password1");
        loginUserMapper.insert(params1);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void insertUser2() throws Exception {
        Map params1=new HashMap<>();
        params1.put("username","shencheng2");
        params1.put("password","password2");
        loginUserMapper.insert(params1);
        throw new RuntimeException("woshiwoshiwoshi");
    }


    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void insertUser3() throws Exception {
        Map params1=new HashMap<>();
        params1.put("username","shencheng3");
        params1.put("password","password3");
        loginUserMapper.insert(params1);
        throw new RuntimeException("woshiwoshiwoshi");
    }

}
