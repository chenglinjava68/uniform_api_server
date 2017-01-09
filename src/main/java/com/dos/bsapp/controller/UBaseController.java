package com.dos.bsapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import javax.servlet.http.HttpServletRequest;

public class UBaseController
{
    private Logger logger = LoggerFactory.getLogger(UBaseController.class);;

    protected void checkRemoteIP(HttpServletRequest request) throws Exception{
        String ip =  null;
        do
        {
            ip = request.getHeader("X-Real-IP");
            if (!StringUtils.isEmpty(ip) && !"unknown".equalsIgnoreCase(ip))
            {
                break;
            }
            ip = request.getHeader("X-Forwarded-For");
            if (!StringUtils.isEmpty(ip) && !"unknown".equalsIgnoreCase(ip))
            {
                // 多次反向代理后会有多个IP值，第一个为真实IP。
                int index = ip.indexOf(',');
                if (index != -1) {
                    ip = ip.substring(0, index);
                    break;
                }
            }
            else
            {
                ip = request.getRemoteAddr();
            }
        }while(false);
        logger.debug("Request IP address:"+ip);
        //String allowIPlist = "127.0.0.1";
        String allowIPlist = "";
        if(allowIPlist.length() == 0)
            return;
        else
        {
            if(allowIPlist.indexOf(ip) == -1 )
                throw new Exception("您地地址无法访问次服务器");
        }
    }
}
