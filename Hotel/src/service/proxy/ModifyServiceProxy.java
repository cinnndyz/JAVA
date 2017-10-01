package service.proxy;

import entity.Member;
import exception.DataAccessException;
import exception.DuplicateUsernameException;
import exception.ServiceException;
import factory.ObjectFactory;
import service.ModifyService;
import transaction.TransactionManager;

public class ModifyServiceProxy implements ModifyService{
	private ModifyService modifyService;
	public ModifyServiceProxy(){
		modifyService=(ModifyService)ObjectFactory.getObject("modifyServiceTarget");
	}
	public void modify(Member member) {
		TransactionManager tran=(TransactionManager) ObjectFactory.getObject("transaction");
		try {			
			tran.beginTransaction();
			modifyService.modify(member);
			tran.commit();
		} catch (DataAccessException e) {
			tran.rollback();
			throw new ServiceException(e);
		} 	
	}
	public void modifyPwd(Member member) {
		TransactionManager tran=(TransactionManager) ObjectFactory.getObject("transaction");
		try {			
			
			tran.beginTransaction();
			modifyService.modifyPwd(member);
			tran.commit();
		} catch (DataAccessException e) {
			tran.rollback();
			throw new ServiceException(e);
		} 	
	
	
	}
	
}
