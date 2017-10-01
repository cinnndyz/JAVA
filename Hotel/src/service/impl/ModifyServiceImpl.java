package service.impl;

import dao.ModifyDao;
import entity.Member;
import exception.DuplicateUsernameException;
import factory.ObjectFactory;
import service.ModifyService;

public class ModifyServiceImpl implements ModifyService{

	public void modify(Member member) {	
		ModifyDao modifyDao=(ModifyDao)ObjectFactory.getObject("modifyDao");
		modifyDao.modify(member);		
	}

	public void modifyPwd(Member member) {
		
		ModifyDao modifyDao=(ModifyDao)ObjectFactory.getObject("modifyDao");
		modifyDao.modifyPwd(member);
	}



}
