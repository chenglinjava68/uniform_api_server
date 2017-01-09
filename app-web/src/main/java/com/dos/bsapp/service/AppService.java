package com.dos.bsapp.service;

import com.dos.bsapp.service.domain.*;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dos.bsapp.dao.AppDao;
import com.dos.bsapp.model.App;

@Service("AppService")
public class AppService
{

    @Resource
    private AppDao appDao;

    @Resource
    private SeriesNumberService seriesNumberService;



    public App aAppAdd(String title) throws Exception
    {
        App output = null ;
        if(appDao.findByTitle(title) != null )
            throw new Exception("指定的名字已经被占用");

        output = App.addApp(title);
        output.setSeriesNumber(seriesNumberService.createAppSeriesNumber());

        appDao.addApp(output);

        return output;
    }

    public App aAppEditTitle(Long id,String title) throws Exception
    {
        App output = appDao.findByTitle(title);
        if(output != null && !id.equals(output.getId()))
            throw new Exception("指定的名字已经被占用");

        output = appDao.get(id.intValue());
        if(output == null ) throw new Exception("APP指定错误。");

        output.setTitle(title);
        appDao.editTitle(output);

        return output;
    }

    public App aAppResetSereisNumber(Long id) throws Exception
    {
        App output = appDao.get(id.intValue());
        if(output == null ) throw new Exception("APP指定错误。");

        output.setSeriesNumber(seriesNumberService.createAppSeriesNumber());
        appDao.resetSeriesNumber(output);
        return output;
    }

    public App aAppSwitchStatus(Long id) throws Exception
    {
        App output = appDao.get(id.intValue());
        if(output == null ) throw new Exception("APP指定错误。");

        output.setIsLock(1-output.getIsLock());
        appDao.editLockStatus(output);
        return output;
    }

}
