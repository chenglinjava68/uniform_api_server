package com.dos.bsapp.controller;


import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import util.MediaTypes;
import util.PostParam;
import util.exception.PostParamException;

import com.dos.bsapp.service.JPushService;


@Controller
@EnableAutoConfiguration
public class UPushController extends UBaseController
{
	private Logger logger = LoggerFactory.getLogger(UPushController.class);;

    @Resource
    private JPushService jPushService;

    public static class DopushParam extends PostParam
    {
        private String unitSeriesNumber;
        public String getUnitSeriesNumber(){ return this.unitSeriesNumber;}
        public void setUnitSeriesNumber(String val ){ this.unitSeriesNumber=val; }


        private String data;
        public String getData(){ return this.data;}
        public void setData(String val ){ this.data=val; }

        private String sign;
        public String getSign(){ return this.sign;}
        public void setSign(String val ){ this.sign=val; }

        @Override
        public boolean checkParam()
        {
            if( this.unitSeriesNumber ==null )
            {
                this.setMessage("我的服务器的SeriesNumber 为空");
                return false;
            }
            if( this.unitSeriesNumber.length() == 0 )
            {
                this.setMessage("我的服务器的SeriesNumber 长度不能为0.");
                return false;
            }
            if( this.data ==null )
            {
                this.setMessage("实际数据 为空");
                return false;
            }
            if( this.sign ==null )
            {
                this.setMessage("签名 为空");
                return false;
            }
            if( this.sign.length() == 0 )
            {
                this.setMessage("签名 长度不能为0.");
                return false;
            }
            return true;
        }
    }


    //推送测试数据
    //curl  --header "Content-Type:application/jso\":\"aos\",\"message\":\"eeeee\",\"register_id\":[\"1a0018970aa7a31c8eb\"],\"extra\":{\"abc\":12,\"ww\":\"d\"}}","sign":"4dd0660acc35f762b02c8d32d5e8560d"}' http://127.0.0.1:10001/api/web/jpush
    @RequestMapping(value = {"api/web/jpush"},method={RequestMethod.POST},produces=MediaTypes.JSON_UTF_8,consumes=MediaTypes.JSON)
    public @ResponseBody util.JO  JPush(@RequestBody DopushParam param){
        try
        {
            if(!param.checkParam()) 
                throw new PostParamException(param.getMessage());

            jPushService.act(
                    param.getUnitSeriesNumber(),
            		param.getData(), 
            		param.getSign());
            return util.JO.ok("成功");
        }
        catch(Exception e)
        {
        	e.printStackTrace();
            return util.JO.fail(e.getMessage());
        }
    }


}
