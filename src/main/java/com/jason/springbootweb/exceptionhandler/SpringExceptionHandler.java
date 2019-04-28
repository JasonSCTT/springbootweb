package com.jason.springbootweb.exceptionhandler;

import com.jason.springbootweb.exception.VoException;
import com.jason.springbootweb.vo.ResponseVo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class SpringExceptionHandler {

    @ExceptionHandler(VoException.class)
    @ResponseBody
    public Object resultReturn(Exception e) {
        Map object = new HashMap<>();
        object.put("msg", e.getMessage());
        ResponseVo responseVo = new ResponseVo(-1, object);
        return responseVo;
    }
}
