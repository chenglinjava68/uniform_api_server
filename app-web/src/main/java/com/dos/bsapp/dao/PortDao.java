package com.dos.bsapp.dao;

import java.util.List;

import com.dos.bsapp.model.Port;

public interface PortDao{
	
	public List<Port> aPortList();

    public List<Port> findByTitle(String title);
    public int addPort(Port port);
    public Port get(Integer id);
    public int editSetting(Port port);
    public int editLockStatus(Port port);


}
