package com.dos.bsapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dos.bsapp.model.VUnit;



public interface VUnitDao
{
    public VUnit getBySeriesNumber( @Param("seriesNumber")String seriesNumber);
    public VUnit getByPortTitleAndAppId(
    		@Param("portTitle")String portTitle,
    		@Param("appId")Integer appId)
    ;
    

}
