package com.jason.springbootweb.dao.pojo;

import lombok.Data;

@Data
public class LoginUser {
    private int id;
    private String username;
    private String password;
    private String picturecode;
}
