package com.dos.bsapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dos.bsapp.model.Unit;

public interface UnitDao
{
    public List<Unit> aUnitList(); //AUTOGE TODO
    public List<Unit> findByAppIdAndPortId(@Param("appId")Integer appId, @Param("portId")Integer portId);
    public Unit get(Integer id);
    public int addUnit(Unit unit);
    public int editSetting(Unit unit);
    public int editLockStatus(Unit unit);

      public int resetSeriesNumber(Unit app);

}
