package com.jason.springbootweb.dao.pojo;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String username;
    private Integer age;
    private Integer customerid;
    private String birthday;
}