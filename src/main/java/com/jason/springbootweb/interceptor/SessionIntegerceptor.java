package com.jason.springbootweb.interceptor;

import com.jason.springbootweb.entity.CurrentUser;
import com.jason.springbootweb.tool.HttpUtil;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SessionIntegerceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        CurrentUser currentUser = HttpUtil.getSession("currentUser");

        if (currentUser == null) {
            System.out.println(HttpUtil.getSession().getAttribute("picutreCode"));
            String redirectPage = "/html/Login.html";
            if (request.getHeader("x-requested-with") != null &&
                    request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) {
                response.setHeader("redirect-page", redirectPage);
            } else {
                String[] parts = request.getRequestURL().toString().split("/");
                String baseLocation = parts[0] + "//" + parts[2];
                response.sendRedirect(baseLocation + redirectPage);
            }
        }
        return true;
    }
}
