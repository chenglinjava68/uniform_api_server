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

import com.dos.bsapp.service.pay.PayService;


@Controller
@EnableAutoConfiguration
public class UPayController extends UBaseController
{
	private Logger logger = LoggerFactory.getLogger(UPayController.class);;

    @Resource
    private PayService payService;

    public static class DopayParam extends PostParam
    {
        private String unitSeriesNumber;
        public String getUnitSeriesNumber(){ return this.unitSeriesNumber;}
        public void setUnitSeriesNumber(String val ){ this.unitSeriesNumber=val; }

        private String action;
        public String getAction(){ return this.action;}
        public void setAction(String val ){ this.action=val; }

        private String order;
        public String getOrder(){ return this.order;}
        public void setOrder(String val ){ this.order=val; }

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
            if( this.action ==null )
            {
                this.setMessage("实际动作名称 为空");
                return false;
            }
            if( this.action.length() == 0 )
            {
                this.setMessage("实际动作名称 长度不能为0.");
                return false;
            }
            if( this.order ==null )
            {
                this.setMessage("订单的序列号 为空");
                return false;
            }
            if( this.order.length() == 0 )
            {
                this.setMessage("订单的序列号 长度不能为0.");
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



    @RequestMapping(value = {"api/web/dopay"},method={RequestMethod.POST},produces=MediaTypes.JSON_UTF_8,consumes=MediaTypes.JSON)
    public @ResponseBody util.JO  dopay(@RequestBody DopayParam param){
        try
        {
            if(!param.checkParam()) 
                throw new PostParamException(param.getMessage());

            Object output = payService.dopay( param.getUnitSeriesNumber(), 
            		param.getAction(),
            		param.getOrder(), 
            		param.getData(), 
            		param.getSign());
            if(output == null)
            {
                return util.JO.fail("失败");
            }
            return util.JO.ok(output);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
            return util.JO.fail(e.getMessage());
        }
    }
    
    @RequestMapping(value = "/api/unionpay/frontrecv_url")
    public String unionpayFrontRecvUrl(HttpServletRequest request,HttpServletResponse response) throws Exception {
    	System.out.println("unionpayFrontRecvUrl is called with data:");
    	return "redirect:" + payService.unionpayFrontRecvUrl(request, response);
    }
    @RequestMapping(value = "/api/unionpay/backrecv_url")
    public void unionpayBackRecvUrl(HttpServletRequest request,HttpServletResponse response) throws Exception {
    	System.out.println("unionpayBackRecvUrl is called with data:");
    	payService.unionpayBackRecvUrl(request, response);
    }
    
    
    @RequestMapping(value = "/api/alipay/return_url")
    public String returnUrl(HttpServletRequest request,HttpServletResponse response) throws Exception {
    	return "redirect:" + payService.alipayReturnCall(request, response);
    }
    
    @RequestMapping(value = "/api/alipay/notify_url")
    public @ResponseBody String notifyUrl(HttpServletRequest request,HttpServletResponse response) throws Exception {
    	return payService.alipayNotifyCall(request, response);
    }


    @RequestMapping(value = "/api/wechatpay/buy_over_notify")
    public void wechatpayNativeNotify(@RequestBody String xmlData,HttpServletRequest request,HttpServletResponse response) throws Exception {
        System.out.println("buy_over_notify is called with data:"+xmlData);
         payService.wechatpayBuyOverNotify(xmlData,request, response);
    }

    @RequestMapping(value = "/api/wechatpay/notify")
    public void wechatpayNotify(@RequestBody String xmlData,HttpServletRequest request,HttpServletResponse response) throws Exception {
        System.out.println("wechatpayNotify is called with data:"+xmlData);
        payService.wechatpayNotify(xmlData,request, response);
    }



}
