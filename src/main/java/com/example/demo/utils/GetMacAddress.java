package com.example.demo.utils;

import javax.servlet.http.HttpServletRequest;

public class GetMacAddress {

    public String getIpAddress(HttpServletRequest request){
        String ip = request.getHeader("X-eal-ip");
        final String un_no = "unknown";
        if(ip == null || ip.length() ==0 || un_no.equalsIgnoreCase(ip) ){
            ip = request.getHeader("x-forwarded-for");
        }
        if(ip == null || ip.length() == 0 || un_no.equalsIgnoreCase(ip)){
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
