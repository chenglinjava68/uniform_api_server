package com.dos.bsapp.service.domain;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dos.bsapp.dao.AppDao;

@Service("SeriesNumberService")
public class SeriesNumberService
{

    @Resource
    private AppDao appDao;

    public String createAppSeriesNumber(){
        String sn = "";
        String sn_bottom = "";
        while(true)
        {
            sn = util.DateUtil.toString(new Date(),"yyMMdd");
            sn_bottom = util.Random.generateWithCharNumber(6);
            String output = sn + sn_bottom;
            if(appDao.countOfSeriesNumber(output) == 0)
                return output;
        }
    }


}
