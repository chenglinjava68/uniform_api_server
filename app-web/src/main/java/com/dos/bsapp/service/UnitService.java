package com.dos.bsapp.service;

import com.dos.bsapp.service.domain.*;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dos.bsapp.dao.UnitDao;
import com.dos.bsapp.model.Unit;

@Service("UnitService")
public class UnitService
{

    @Resource
    private UnitDao unitDao;

    @Resource
    private SeriesNumberService seriesNumberService;

    public Unit aUnitAdd(Long appId,Long portId,String setting) throws Exception
    {
        Unit output = null ;
        if(unitDao.findByAppIdAndPortId(appId.intValue(),portId.intValue()).size() > 0 )
            throw new Exception("指定的UNIT已经存在");

        output = Unit.addUnit(appId.intValue(),portId.intValue(),setting);
        output.setSeriesNumber(seriesNumberService.createAppSeriesNumber());
        unitDao.addUnit(output);
        return output;
    }

    public Unit aUnitEditSetting(Long id,String setting) throws Exception
    {
        Unit output = unitDao.get(id.intValue());
        if(output == null ) throw new Exception("Unit指定错误。");
        output.setSetting(setting);
        unitDao.editSetting(output);
        return output;
    }

    public Unit aUnitSwitchStatus(Long id) throws Exception
    {
        Unit output = unitDao.get(id.intValue());
        if(output == null ) throw new Exception("Unit指定错误。");

        output.setIsLock(1-output.getIsLock());
        unitDao.editLockStatus(output);
        return output;
    }

     public Unit aUnitResetSeriesNumber(Long id) throws Exception
        {
            Unit output = unitDao.get(id.intValue());
            if(output == null ) throw new Exception("Unit指定错误。");

            output.setSeriesNumber(seriesNumberService.createAppSeriesNumber());
            unitDao.resetSeriesNumber(output);
            return output;
        }



}
