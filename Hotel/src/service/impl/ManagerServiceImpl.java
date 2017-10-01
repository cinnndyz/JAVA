package service.impl;

import constant.Constant;
import dao.ManagerDao;
import entity.Manager;
import exception.UserDisabledException;
import exception.UserNotFoundException;
import factory.ObjectFactory;
import service.ManagerService;
import util.MD5Util;

public class ManagerServiceImpl implements ManagerService{

	public Manager login(String username, String password) throws UserNotFoundException, UserDisabledException {
		
		ManagerDao managerDao=(ManagerDao)ObjectFactory.getObject("managerDao");
		Manager manager=managerDao.selectByUsernameAndPassword(username, password);
		if(manager==null){
			throw new UserNotFoundException("用户名或密码错误");
		}		
		return manager;
	}

}
