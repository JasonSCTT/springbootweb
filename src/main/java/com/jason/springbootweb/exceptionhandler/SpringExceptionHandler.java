package com.jason.springbootweb.exceptionhandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class SpringExceptionHandler {

@ExceptionHandler(Exception.class)
@ResponseBody
   public Object resultReturn(Exception e){
      Map object =new HashMap<>();
      object.put("exception","捕获到异常了");
      return  object;
   }
}
