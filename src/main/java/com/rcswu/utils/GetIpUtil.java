package com.rcswu.utils;



import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

public class GetIpUtil {
    public static final String getIpAddr(final HttpServletRequest request){
        String ipString=request.getHeader("x-forwarded-for");
        if(StringUtils.isBlank(ipString)||"unknown".equalsIgnoreCase(ipString)){
            ipString=request.getHeader("Proxy-Client-IP");
        }
        if(StringUtils.isBlank(ipString)||"unknown".equalsIgnoreCase(ipString)){
            ipString=request.getHeader("WL-Proxy-Client-IP");
        }
        if(StringUtils.isBlank(ipString)||"unknown".equalsIgnoreCase(ipString)){
            ipString=request.getRemoteAddr();
        }
        final String[] arr=ipString.split(",");
        for(final String str:arr){
            if(!"unknown".equalsIgnoreCase(str)){
                ipString=str;
                break;
            }
        }
        return ipString;
    }
}
