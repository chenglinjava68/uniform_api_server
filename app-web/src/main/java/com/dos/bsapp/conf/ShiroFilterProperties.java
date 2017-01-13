package com.dos.bsapp.conf;

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
}