package com.dos.bsapp.store;

import java.util.List;
import org.springframework.stereotype.Service;

import com.dos.bsapp.dao.VUnitDao;
import com.dos.bsapp.model.VUnit;

import javax.annotation.Resource;


@Service("UnitStore")
public class UnitStore
{
    @Resource
    private VUnitDao vUnitDao;

    public VUnit getBySeriesNumber(String seriesNumber){
        return vUnitDao.getBySeriesNumber(seriesNumber);
    }

}
