package com.lzc.blog.aspect;

import com.lzc.blog.annotation.LogAnnotation;
import com.lzc.blog.mapper.LogMapper;
import com.lzc.blog.pojo.Log;
import com.lzc.blog.pojo.User;
import com.lzc.blog.utils.IPUtils;
import com.lzc.blog.utils.RequestUtils;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @Author liuzhoucheng
 * @Date 2021/11/29 12:31
 * @Version 1.0
 */
@Aspect
@Component
public class MyLogAspect {
    @Autowired
    private LogMapper logMapper;

    @Pointcut("@annotation(com.lzc.blog.annotation.LogAnnotation)")
    public void pointCut(){

    }

    @After("pointCut()")
    public void around(JoinPoint point) {
        // 执行时长(毫秒)
        Date time = new Date();
        // 保存日志
        saveLog(point, time);
    }

    public void saveLog(JoinPoint point, Date time){
        MethodSignature signature =(MethodSignature) point.getSignature();
        LogAnnotation annotation = signature.getMethod().getAnnotation(LogAnnotation.class);
        String value = annotation.value();//注解信息
        Log log = new Log();
        if(value!=null){
            log.setOperation(value);
        }

        HttpServletRequest request = RequestUtils.getRequest();
        log.setIp(IPUtils.getIpAddr(request));
        User user = (User)request.getSession().getAttribute("user");
        if(user!=null){
            log.setUsername(user.getNickname());
        }else{
            log.setUsername("游客");
        }
        log.setCreateTime(time);
        log.setBrowser(RequestUtils.getBrowser());
        logMapper.saveLog(log);
    }
}
