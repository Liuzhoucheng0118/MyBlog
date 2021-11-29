package com.lzc.blog.utils;

import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import eu.bitwalker.useragentutils.Version;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author liuzhoucheng
 * @Date 2021/11/29 12:51
 * @Version 1.0
 */
public class RequestUtils {
    public static HttpServletRequest getRequest(){
        return  ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
    }
    public static String  getBrowser(){
        UserAgent userAgent = UserAgent.parseUserAgentString(getRequest().getHeader("User-Agent"));
        String browser = userAgent.getBrowser().getName();
        String operatingSystem = userAgent.getOperatingSystem().getName();
        return operatingSystem+" "+browser;
    }
}
