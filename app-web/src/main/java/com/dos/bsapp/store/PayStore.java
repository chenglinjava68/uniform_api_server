package com.dos.bsapp.store;

import org.springframework.stereotype.Service;

import com.dos.bsapp.dao.AppPayDao;
import com.dos.bsapp.model.AppPay;

import javax.annotation.Resource;


@Service("PayStore")
public class PayStore
{
    @Resource
    private AppPayDao appPayDao;

    public AppPay registerOrderForApp(Integer appId,String appSeriesNumber,String orderSeriesNumber,Integer regUnit) throws Exception{
        AppPay ap = appPayDao.getByAppOrder(appId,orderSeriesNumber);
        if(ap == null ||ap.getId() == 0L)
         {
            ap = AppPay.newPay(appId,appSeriesNumber,orderSeriesNumber,regUnit);
            appPayDao.newAppPay(ap);
         }
        return ap;
    }
}
