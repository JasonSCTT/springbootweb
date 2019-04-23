package com.jason.springbootweb.tool;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

public class HttpUtil {
    // 获取session
    public static HttpSession getSession(){
        ServletRequestAttributes attrs=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return  attrs.getRequest().getSession();
    }

    // 通过name获取相应的对象的值
    public static <T> T getSession(String name){
        return  (T)getSession().getAttribute(name);
    }

    public static <T> void setUser(String name, T item) {
        getSession().setAttribute(name, item);
    }

}
