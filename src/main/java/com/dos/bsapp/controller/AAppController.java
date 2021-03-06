package com.dos.bsapp.controller;


import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dos.util.MediaTypes;

import com.dos.util.*;

@RestController
@EnableAutoConfiguration
public class AAppController
{
    private Logger logger = LoggerFactory.getLogger(AAppController.class);


    @RequestMapping(value = {"api/web/test"},method={RequestMethod.GET},produces=MediaTypes.JSON_UTF_8,consumes=MediaTypes.JSON)
    public Object test(){
        try
        {
            return Ret.ok("ok");
        }
        catch(Exception e)
        {
            return Ret.no("no");
        }
    }

    @RequestMapping(value = {"need_login"},method={RequestMethod.GET,RequestMethod.POST})
    public Object nnedLogin(){
        return Ret.auth("您当前没有登录");
    }



}
