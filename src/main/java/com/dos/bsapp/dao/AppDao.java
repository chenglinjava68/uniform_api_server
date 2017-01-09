package com.dos.bsapp.dao;

import java.util.List;

import com.dos.bsapp.model.App;
public interface AppDao
{
    public List<App> aAppList();
    public int countOfSeriesNumber(String seriesNumber);
    public int addApp(App app);
    public App findByTitle(String title);
    public App get(Integer id);
    public int editTitle(App app);
    public int resetSeriesNumber(App app);
    public int editLockStatus(App app);
}
