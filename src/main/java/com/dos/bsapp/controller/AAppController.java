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

import com.dos.bsapp.dao.AppDao;
import com.dos.bsapp.model.App;
import com.dos.bsapp.service.AppService;

import util.JO;
import util.MediaTypes;
import util.PostParam;
import util.exception.PostParamException;
import util.exception.UserNeedLoginException;

@RestController
@EnableAutoConfiguration
public class AAppController
{
    private Logger logger = LoggerFactory.getLogger(AAppController.class);;

    @Resource
    private AppDao appDao;

    @Resource
    private AppService appService;

    public static class AAppAddParam extends util.PostParam
    {
        private String title;
        public String getTitle(){ return this.title;}
        public void setTitle(String val ){ this.title=val; }

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
            return true;
        }
    }

    public static class AAppEditTitleParam extends  util.PostParam
    {
        private Long id;
        public Long getId(){ return this.id;}
        public void setId(Long val ){ this.id=val; }

        private String title;
        public String getTitle(){ return this.title;}
        public void setTitle(String val ){ this.title=val; }

        @Override
        public boolean checkParam()
        {
            if( this.id ==null )
            {
                this.setMessage("ID 为空");
                return false;
            }
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
            return true;
        }
    }

    public static class AAppResetSereisNumberParam extends  util.PostParam
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

    public static class AAppSwitchStatusParam extends  util.PostParam
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



    @RequestMapping(value = {"api/web/a_app_list"},method={RequestMethod.GET},produces=MediaTypes.JSON_UTF_8)
    public  JO aAppList(){
        try
        {
            List<App> output = appDao.aAppList();
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


    @RequestMapping(value = {"api/web/a_app_add"},method={RequestMethod.POST},produces=MediaTypes.JSON_UTF_8,consumes=MediaTypes.JSON)
    public JO aAppAdd(@RequestBody AAppAddParam param){
        try
        {
            if(!param.checkParam()) 
                throw new PostParamException(param.getMessage());

            App output = appService.aAppAdd( param.getTitle());
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


    @RequestMapping(value = {"api/web/a_app_edit_title"},method={RequestMethod.POST},produces=MediaTypes.JSON_UTF_8,consumes=MediaTypes.JSON)
    public JO aAppEditTitle(@RequestBody AAppEditTitleParam param){
        try
        {
            if(!param.checkParam()) 
                throw new PostParamException(param.getMessage());

            App output = appService.aAppEditTitle( param.getId(), param.getTitle());
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


    @RequestMapping(value = {"api/web/a_app_reset_sereis_number"},method={RequestMethod.POST},produces=MediaTypes.JSON_UTF_8,consumes=MediaTypes.JSON)
    public JO aAppResetSereisNumber(@RequestBody AAppResetSereisNumberParam param){
        try
        {
            if(!param.checkParam()) 
                throw new PostParamException(param.getMessage());

            App output = appService.aAppResetSereisNumber( param.getId());
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


    @RequestMapping(value = {"api/web/a_app_switch_status"},method={RequestMethod.POST},produces=MediaTypes.JSON_UTF_8,consumes=MediaTypes.JSON)
    public JO aAppSwitchStatus(@RequestBody AAppSwitchStatusParam param){
        try
        {
            if(!param.checkParam()) 
                throw new PostParamException(param.getMessage());

            App output = appService.aAppSwitchStatus( param.getId());
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
