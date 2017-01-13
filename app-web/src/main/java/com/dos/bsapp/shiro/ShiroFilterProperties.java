package com.dos.bsapp.shiro;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;



@Component
@ConfigurationProperties(prefix="shiro")
public class ShiroFilterProperties {

    Map<String, String> filters = new HashMap<String, String>();
     public Map<String, String> getFilters() {
        return filters;
    }

    public void setFilters(Map<String, String> f) {
        this.filters = f;
    }


    String loginUrl = "/need_login";
    public String getLoginUrl() { return loginUrl; }
    public void setLoginUrl(String val ) { loginUrl = val; }

    String successUrl = "/index";
    public String getSuccessUrl() { return successUrl; }
    public void setSuccessUrl(String val ) { successUrl = val; }


    String unauthorizedUrl = "/403";
    public String getUnauthorizedUrl() { return unauthorizedUrl; }
    public void setUnauthorizedUrl(String val){ unauthorizedUrl = val; }


    String userService = "com.dos.bsapp.shiro.ShiroUserService";
    public String getUserService() { return userService; }
    public void setUserService(String val){ userService = val; }
}