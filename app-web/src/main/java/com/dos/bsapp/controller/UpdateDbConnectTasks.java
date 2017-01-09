package com.dos.bsapp.controller;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.dos.bsapp.dao.AppDao;

@Component
public class UpdateDbConnectTasks {
	@Resource
	private AppDao appDao;
	@Scheduled(fixedRate = 600000)
	public void refreshConnection(){
		System.out.println("UpdateDbConnectTasks-refreshConnection");
		appDao.aAppList();
	}
}
