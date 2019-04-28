package com.jason.springbootweb.vo;

import lombok.Data;

import java.util.HashMap;

@Data
public class ResponseVo {
    //返回的结果对象
    private Object data;
    //返回的状态码
    private int code;

    public ResponseVo() {
    }

    public ResponseVo(int  code, Object data) {
        this.code = code;
        this.data = data;
    }


}
