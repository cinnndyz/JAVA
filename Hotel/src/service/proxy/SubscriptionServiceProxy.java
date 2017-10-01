package service.proxy;



import java.util.ArrayList;
import java.util.List;

import entity.Subscription;
import entity.Subscription_dtl;
import exception.DataAccessException;
import exception.ServiceException;
import factory.ObjectFactory;
import service.SubscriptionService;
import transaction.TransactionManager;

public class SubscriptionServiceProxy implements SubscriptionService{
	private SubscriptionService subscriptionService;
	public SubscriptionServiceProxy(){
		subscriptionService=(SubscriptionService)ObjectFactory.getObject("subscriptionServiceTarget");
	}
	public void regist(Subscription subscription) {
		TransactionManager tran=(TransactionManager) ObjectFactory.getObject("transaction");
		
		try {
			tran.beginTransaction();
			subscriptionService.regist(subscription);
			tran.commit();
		} catch (DataAccessException e) {
			tran.rollback();
			throw new ServiceException(e);
		}
	
	
	}
	public List<Subscription> show(int id) {
		TransactionManager tran=(TransactionManager) ObjectFactory.getObject("transaction");
		
		List<Subscription>  subscriptions=null;
		try {
			tran.beginTransaction();
			subscriptions=subscriptionService.show(id);			
			tran.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tran.rollback();			
		}		 
		return subscriptions;
	}
	public List<Subscription> showmessage(int id) {
		TransactionManager tran=(TransactionManager) ObjectFactory.getObject("transaction");
		
		List<Subscription>  subscriptions=null;
		try {
			tran.beginTransaction();
			subscriptions=subscriptionService.showmessage(id);
			tran.commit();
		}catch (Exception e) {
			e.printStackTrace();
			tran.rollback();			
		}		 
		return subscriptions;
	}
	public void modifymessage(Subscription subscription) {
		TransactionManager tran=(TransactionManager) ObjectFactory.getObject("transaction");
		
		try {
			tran.beginTransaction();
			subscriptionService.modifymessage(subscription);
			tran.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tran.rollback();
		}
		
		
	}
	public List<Subscription_dtl> select(Integer id) {
	
		TransactionManager tran=(TransactionManager) ObjectFactory.getObject("transaction");
		List<Subscription_dtl> Subscription_dtls=null;
		try {
			tran.beginTransaction();
			Subscription_dtls=(List<Subscription_dtl>)subscriptionService.select(id);
			tran.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tran.rollback();
		}
		return Subscription_dtls;
	}
	public void delete(Integer id) {
		
		TransactionManager tran=(TransactionManager) ObjectFactory.getObject("transaction");
		try {
			tran.beginTransaction();
			subscriptionService.delete(id);
			tran.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tran.rollback();
		}
	}
	public List<Subscription> showhistory(int id) {
TransactionManager tran=(TransactionManager) ObjectFactory.getObject("transaction");
		
		List<Subscription>  subscriptions=null;
		try {
			tran.beginTransaction();
			subscriptions=subscriptionService.showhistory(id);			
			tran.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tran.rollback();			
		}		 
		return subscriptions;
		
	}

}
