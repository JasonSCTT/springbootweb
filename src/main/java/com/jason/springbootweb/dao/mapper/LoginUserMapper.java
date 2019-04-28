package com.jason.springbootweb.dao.mapper;

import com.jason.springbootweb.dao.pojo.LoginUser;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface LoginUserMapper {
    int insert(Map params);

    LoginUser getLoginUser(Map params);

    Boolean isExist(Map params);
}
