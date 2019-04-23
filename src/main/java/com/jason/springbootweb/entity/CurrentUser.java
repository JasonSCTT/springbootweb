package com.jason.springbootweb.entity;

import lombok.Data;

@Data
public class CurrentUser {
    private String username;
    private String password;
    private String pictureCode;
}
