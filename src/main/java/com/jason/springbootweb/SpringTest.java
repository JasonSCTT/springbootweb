package com.eastmoney.web;


import com.jason.springbootweb.SpringbootwebApplication;
import com.jason.springbootweb.dao.mapper.LoginUserMapper;
import com.jason.springbootweb.listen.RuleChangedEventPublisher;
import com.jason.springbootweb.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationEvent;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yuanchunming
 * @description test
 * @date 2019/7/11
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootwebApplication.class)
public class SpringTest {

    @Autowired
    private LoginUserMapper loginUserMapper;

    @Autowired
    private UserService userService;


    @Autowired
    private RuleChangedEventPublisher ruleChangedEventPublisher;


    @Transactional
    @org.junit.Test
    public void Test() throws Exception {
        userService.insertUser1();
        userService.insertUser2();

    }

    @Test
    public void deleteAll(){
        loginUserMapper.deleteAll();
    }


    @Test
    public void testAbc(){
//        ruleChangedEventPublisher.publishRuleChangedEvent(new ApplicationEvent("我的来源是test") {});
    }




}
