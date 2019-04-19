package com.jason.springbootweb.vo;

import lombok.Data;

import java.util.HashMap;

@Data
public class ResponseVo {
    //是否成功
    private boolean success;
    //返回的结果对象
    private Object resultObject;

    public ResponseVo() {
    }

    public ResponseVo(Boolean success, Object resultObject) {
        this.success = success;
        this.resultObject = resultObject;
    }


}
