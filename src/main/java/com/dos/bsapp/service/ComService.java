package com.dos.bsapp.service;

import java.util.Date;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dos.bsapp.controller.UPayController;
import com.dos.bsapp.model.VUnit;
import com.dos.bsapp.store.UnitStore;

@Service("ComService")
public class ComService
{
	private Logger logger = LoggerFactory.getLogger(UPayController.class);
	
    @Resource
    private UnitStore unitStore;

    public VUnit checkIfStatus(String unitSeriesNumber, String prefix,String requestData, String sign) throws Exception
    {
        VUnit vunit = unitStore.getBySeriesNumber(unitSeriesNumber);
        if(!vunit.isUsable()) {
        	logger.error("ComService.checkIfStatus " + unitSeriesNumber + " 申请的服务已经失效");
        	throw new Exception("您申请的服务已经失效");
        }
        String sDataToEncry = prefix + requestData + vunit.getAppSeriesNumber();
        logger.debug("sDataToEncry is:"+sDataToEncry);
        String sData = util.MD5.getMD5ofString(sDataToEncry);
        logger.debug("sign is:"+sign + "  sData:"+sData);
        if(!sData.equals(sign)) {
        	logger.error("ComService.checkIfStatus " + unitSeriesNumber + " 加密的数据有问题");
        	throw new Exception("加密的数据有问题");
        }
        return vunit;
    }


}
