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

import com.dos.bsapp.dao.UnitDao;
import com.dos.bsapp.model.Unit;
import com.dos.bsapp.service.UnitService;

import util.JO;
import util.MediaTypes;
import util.PostParam;
import util.exception.PostParamException;
import util.exception.UserNeedLoginException;

import util.exception.*;

@RestController
@EnableAutoConfiguration
public class AUnitController
{
    private Logger logger = LoggerFactory.getLogger(AUnitController.class);;

    @Resource
    private UnitDao unitDao;

    @Resource
    private UnitService unitService;

    public static class AUnitAddParam extends  util.PostParam
    {
        private Long appId;
        public Long getAppId(){ return this.appId;}
        public void setAppId(Long val ){ this.appId=val; }

        private Long portId;
        public Long getPortId(){ return this.portId;}
        public void setPortId(Long val ){ this.portId=val; }

        private String setting;
        public String getSetting(){ return this.setting;}
        public void setSetting(String val ){ this.setting=val; }

        @Override
        public boolean checkParam()
        {
            if( this.appId ==null )
            {
                this.setMessage("关联的App 为空");
                return false;
            }
            if( this.portId ==null )
            {
                this.setMessage("关联的port 为空");
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

    public static class AUnitEditSettingParam extends  util.PostParam
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

    public static class AUnitSwitchStatusParam extends  util.PostParam
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

    public static class AUnitResetSeriesNumberParam extends  util.PostParam
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



    @RequestMapping(value = {"api/web/a_unit_list"},method={RequestMethod.GET},produces=MediaTypes.JSON_UTF_8)
    public JO aUnitList(){
        try
        {
            List<Unit> output = unitDao.aUnitList();
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


    @RequestMapping(value = {"api/web/a_unit_add"},method={RequestMethod.POST},produces=MediaTypes.JSON_UTF_8,consumes=MediaTypes.JSON)
    public  JO aUnitAdd(@RequestBody AUnitAddParam param){
        try
        {
            if(!param.checkParam()) 
                throw new PostParamException(param.getMessage());

            Unit output = unitService.aUnitAdd( param.getAppId(), param.getPortId(), param.getSetting());
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


    @RequestMapping(value = {"api/web/a_unit_edit_setting"},method={RequestMethod.POST},produces=MediaTypes.JSON_UTF_8,consumes=MediaTypes.JSON)
    public  JO aUnitEditSetting(@RequestBody AUnitEditSettingParam param){
        try
        {
            if(!param.checkParam()) 
                throw new PostParamException(param.getMessage());

            Unit output = unitService.aUnitEditSetting( param.getId(), param.getSetting());
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


    @RequestMapping(value = {"api/web/a_unit_switch_status"},method={RequestMethod.POST},produces=MediaTypes.JSON_UTF_8,consumes=MediaTypes.JSON)
    public  JO aUnitSwitchStatus(@RequestBody AUnitSwitchStatusParam param){
        try
        {
            if(!param.checkParam()) 
                throw new PostParamException(param.getMessage());

            Unit output = unitService.aUnitSwitchStatus( param.getId());
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



        @RequestMapping(value = {"api/web/a_unit_reset_series_number"},method={RequestMethod.POST},produces=MediaTypes.JSON_UTF_8,consumes=MediaTypes.JSON)
            public  util.JO  aUnitResetSeriesNumber(@RequestBody AUnitResetSeriesNumberParam param){
                try
                {
                    if(!param.checkParam())
                        throw new PostParamException(param.getMessage());

                    Unit output = unitService.aUnitResetSeriesNumber( param.getId());
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
