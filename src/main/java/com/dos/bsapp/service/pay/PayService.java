package com.dos.bsapp.service.pay;


import java.util.ArrayList;
import com.dos.bsapp.service.*;
import com.dos.bsapp.store.PayStore;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dos.bsapp.model.VUnit;
import com.dos.bsapp.model.AppPay;

@Service("PayService")
public class PayService  extends ComService
{
    @Resource
    private AlipayService alipayService;

    @Resource
    private WechatpayService wechatpayService;
    
    @Resource
    private UnionpayService unionpayService;

    @Resource
    private PayStore payStore;

    protected PayIf selectHandler(String portName){
        if(alipayService.canProcessPort(portName))
            return alipayService;
        if(wechatpayService.canProcessPort(portName))
            return wechatpayService;
        if(unionpayService.canProcessPort(portName))
            return unionpayService;
        System.out.println("selectHandler will return null");
        return null;
    }

    public Object dopay(String unitSeriesNumber,
    		String action, 
    		String orderSeriesNumber, 
    		String data,
    		String sign) throws Exception
    {
        VUnit vunit = checkIfStatus(unitSeriesNumber,orderSeriesNumber,data,sign);
        AppPay ap = payStore.registerOrderForApp(vunit.getAppId(),vunit.getAppSeriesNumber(),orderSeriesNumber,vunit.getId());
        if(ap==null)
        {
            throw new Exception("订单在支付系统中注册失败");
        }
        PayIf handler = selectHandler(vunit.getPortTitle());
        if(handler == null){
        	throw new Exception("支付处理模块不存在。");
        }
        Object obj = handler.process(vunit,ap,action,orderSeriesNumber,data);
        
        return obj;
    }
    
    public String alipayReturnCall(HttpServletRequest request,HttpServletResponse response) throws Exception {
    	return alipayService.returnCall(request,response);
    }
    public String alipayNotifyCall(HttpServletRequest request,HttpServletResponse response) throws Exception {
    	return alipayService.notifyCall(request,response);
    }

    public void wechatpayBuyOverNotify(String xmlData, HttpServletRequest request,HttpServletResponse response) throws Exception {
        	wechatpayService.buyOverNotify(xmlData,request,response);
    }
    public void wechatpayNotify(String xmlData, HttpServletRequest request,HttpServletResponse response) throws Exception {
        	 wechatpayService.notify(xmlData,request,response);
    }

	public String unionpayFrontRecvUrl(HttpServletRequest request, HttpServletResponse response) {
		return unionpayService.unionpayFrontRecvUrl(request,response);
	}

	public String unionpayBackRecvUrl(HttpServletRequest request, HttpServletResponse response) {
		return unionpayService.unionpayBackRecvUrl(request,response);
	}



}
