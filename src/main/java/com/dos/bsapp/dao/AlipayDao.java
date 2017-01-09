package com.dos.bsapp.dao;

import java.util.List;

import com.dos.bsapp.model.AlipayCallbackLog;
import com.dos.bsapp.model.App;
public interface AlipayDao
{
    public void addCallbackLog(AlipayCallbackLog log);
}
