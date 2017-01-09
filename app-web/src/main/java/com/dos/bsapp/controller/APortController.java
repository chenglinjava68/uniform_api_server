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

import com.dos.bsapp.dao.PortDao;
import com.dos.bsapp.model.Port;
import com.dos.bsapp.service.PortService;

import util.JO;
import util.MediaTypes;
import util.PostParam;
import util.exception.PostParamException;
import util.exception.UserNeedLoginException;

import util.exception.*;


@RestController
@EnableAutoConfiguration
public class APortController
{
    private Logger logger = LoggerFactory.getLogger(APortController.class);;

    @Resource
    private PortDao portDao;

    @Resource
    private PortService portService;

    public static class APortAddParam extends  util.PostParam
    {
        private String title;
        public String getTitle(){ return this.title;}
        public void setTitle(String val ){ this.title=val; }

        private String setting;
        public String getSetting(){ return this.setting;}
        public void setSetting(String val ){ this.setting=val; }

        @Override
        public boolean checkParam()
        {
            if( this.title ==null )
            {
                this.setMessage("名称 为空");
                return false;
            }
            if( this.title.length() == 0 )
            {
                this.setMessage("名称 长度不能为0.");
                return false;
            }
            if( this.setting ==null )
            {
                this.setMessage("基础配置 为空");
                return false;
            }
            if( this.setting.length() == 0 )
            {
                this.setMessage("基础配置 长度不能为0.");
                return false;
            }
            return true;
        }
    }

    public static class APortEditSettingParam extends  util.PostParam
    {
        private Long id;
        public Long getId(){ return this.id;}
        public void setId(Long val ){ this.id=val; }

        private String setting;
        public String getSetting(){ return this.setting;}
        public void setSetting(String val ){ this.setting=val; }

        @Override
        public boolean checkParam()
        {
            if( this.id ==null )
            {
                this.setMessage("ID 为空");
                return false;
            }
            if( this.setting ==null )
            {
                this.setMessage("设置信息 为空");
                return false;
            }
            if( this.setting.length() == 0 )
            {
                this.setMessage("设置信息 长度不能为0.");
                return false;
            }
            return true;
        }
    }

    public static class APortSwitchStatusParam extends  util.PostParam
    {
        private Long id;
        public Long getId(){ return this.id;}
        public void setId(Long val ){ this.id=val; }

        @Override
        public boolean checkParam()
        {
            if( this.id ==null )
            {
                this.setMessage("ID 为空");
                return false;
            }
            return true;
        }
    }



    @RequestMapping(value = {"api/web/a_port_list"},method={RequestMethod.GET},produces=MediaTypes.JSON_UTF_8)
    public  JO aPortList(){
        try
        {
            List<Port> output = portDao.aPortList();
            if(output == null)
            {
                return util.JO.fail("失败");
            }
            return util.JO.ok(output);
        }
        /*
        catch(UserNeedLoginException e)
        {
            return util.JO.needLogin(e.getMessage());
        }*/
        catch(Exception e)
        {
            return util.JO.fail(e.getMessage());
        }
    }


    @RequestMapping(value = {"api/web/a_port_add"},method={RequestMethod.POST},produces=MediaTypes.JSON_UTF_8,consumes=MediaTypes.JSON)
    public JO aPortAdd(@RequestBody APortAddParam param){
        try
        {
            if(!param.checkParam()) 
                throw new PostParamException(param.getMessage());

            Port output = portService.aPortAdd( param.getTitle(), param.getSetting());
            if(output == null)
            {
                return util.JO.fail("失败");
            }
            return util.JO.ok(output);
        }
        catch(UserNeedLoginException e)
        {
            return util.JO.needLogin(e.getMessage());
        }
        catch(Exception e)
        {
            return util.JO.fail(e.getMessage());
        }
    }


    @RequestMapping(value = {"api/web/a_port_edit_setting"},method={RequestMethod.POST},produces=MediaTypes.JSON_UTF_8,consumes=MediaTypes.JSON)
    public  JO aPortEditSetting(@RequestBody APortEditSettingParam param){
        try
        {
            if(!param.checkParam()) 
                throw new PostParamException(param.getMessage());

            Port output = portService.aPortEditSetting( param.getId(), param.getSetting());
            if(output == null)
            {
                return util.JO.fail("失败");
            }
            return util.JO.ok(output);
        }
        catch(UserNeedLoginException e)
        {
            return util.JO.needLogin(e.getMessage());
        }
        catch(Exception e)
        {
            return util.JO.fail(e.getMessage());
        }
    }


    @RequestMapping(value = {"api/web/a_port_switch_status"},method={RequestMethod.POST},produces=MediaTypes.JSON_UTF_8,consumes=MediaTypes.JSON)
    public  JO aPortSwitchStatus(@RequestBody APortSwitchStatusParam param){
        try
        {
            if(!param.checkParam()) 
                throw new PostParamException(param.getMessage());

            Port output = portService.aPortSwitchStatus( param.getId());
            if(output == null)
            {
                return util.JO.fail("失败");
            }
            return util.JO.ok(output);
        }
        catch(UserNeedLoginException e)
        {
            return util.JO.needLogin(e.getMessage());
        }
        catch(Exception e)
        {
            return util.JO.fail(e.getMessage());
        }
    }


}
