package com.jason.springbootweb.listen;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Repository;

/**
 * @Description
 * @Author jason
 * @Date 2022-08-05
 */
@Repository
public class MyListener implements ApplicationListener<ApplicationEvent> {
    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        System.out.println("是否触发了这个监听器");
    }
}

