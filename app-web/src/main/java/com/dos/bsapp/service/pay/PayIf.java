package com.dos.bsapp.service.pay;


import java.util.ArrayList;
import com.dos.bsapp.model.VUnit;
import com.dos.bsapp.model.AppPay;

public abstract class PayIf
{
    public abstract boolean canProcessPort(String portName);
    public abstract String  createPayLink(VUnit unit,AppPay ap,String orderSeriesNumber,String data) throws Exception;
    public Object process(VUnit unit,AppPay ap,String action, String orderSeriesNumber,String data) throws Exception
    {
    	System.out.println("action is:"+action);
        if("queryStatus".equals(action))
        {
            return ap;
        }

        if("createPayLink".equals(action))
        {
            String payLink = createPayLink(unit,ap,orderSeriesNumber,data);
            System.out.println("PayIf created Paylink:"+payLink);
            return payLink;
        }
        
        return "";

    }
}
