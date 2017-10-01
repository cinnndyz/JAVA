package service.proxy;

import entity.Manager;
import exception.DataAccessException;
import exception.ServiceException;
import exception.UserDisabledException;
import exception.UserNotFoundException;
import factory.ObjectFactory;
import service.ManagerService;
import service.MemberService;
import transaction.TransactionManager;

public class ManagerServiceProxy implements ManagerService{
	private ManagerService managerService;
	public ManagerServiceProxy(){
		managerService=(ManagerService) ObjectFactory.getObject("managerServiceTarget");
	}
	public Manager login(String username, String password) throws UserNotFoundException, UserDisabledException {
		Manager manager=null;
		TransactionManager tran=(TransactionManager) ObjectFactory.getObject("transaction");
		
		try {
			tran.beginTransaction();						
			manager=managerService.login(username, password);
			tran.commit();
		} catch (DataAccessException e) {
			tran.rollback();
			throw new ServiceException(e);
		} catch (UserNotFoundException e) {
			tran.rollback();
			throw e;
		} catch (UserDisabledException e) {
			tran.rollback();
			throw e;
		}
		return manager;
	}
	
}
