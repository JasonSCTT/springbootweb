package com.jason.springbootweb;

import com.jason.springbootweb.dao.mapper.LoginUserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootwebApplicationTests {
	@Autowired
	private LoginUserMapper loginUserMapper;
	@Test
	public void contextLoads() {
		Map params=new HashMap();
		params.put("username","jason123");
		params.put("password","jason12312");
		System.out.println(loginUserMapper.insert(params));
		System.out.println(loginUserMapper.isExist(params));
	}

}
