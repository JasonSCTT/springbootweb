package com.jason.springbootweb.dao.mapper;

import com.jason.springbootweb.dao.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User selectUserbyName(String name);

    Integer insertUser(User user);

}
