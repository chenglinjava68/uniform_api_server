package com.dos.bsapp.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dos.bsapp.dao.PortDao;
import com.dos.bsapp.model.Port;

@Service("PortService")
public class PortService
{

    @Resource
    private PortDao portDao;

    public Port aPortAdd(String title,String setting) throws Exception
    {
        Port output = null ;
        if(portDao.findByTitle(title).size() > 0  )
            throw new Exception("指定的名字已经被占用");

        output = Port.addPort(title,setting);

        portDao.addPort(output);

        return output;
    }

    public Port aPortEditSetting(Long id,String setting) throws Exception
    {
        Port output = portDao.get(id.intValue());
        if(output == null ) throw new Exception("Port指定错误。");
        output.setSetting(setting);
        portDao.editSetting(output);
        return output;
    }

    public Port aPortSwitchStatus(Long id) throws Exception
    {
        Port output = portDao.get(id.intValue());
        if(output == null ) throw new Exception("Port指定错误。");

        output.setIsLock(1-output.getIsLock());
        portDao.editLockStatus(output);
        return output;
    }

}
