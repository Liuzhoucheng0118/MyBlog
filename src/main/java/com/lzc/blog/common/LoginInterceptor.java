package com.lzc.blog.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        if (user==null){
            log.debug("未成功登陆请求"+request.getRequestURI());

            response.sendRedirect(request.getContextPath()+"/admin");
            return false;
        }
        log.debug("放行请求"+request.getRequestURI());
        return true;
    }
}
