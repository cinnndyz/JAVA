package service.proxy;

import java.util.List;

import entity.Room;
import entity.Subscription;
import entity.Subscription_dtl;
import factory.ObjectFactory;
import service.Subscription_dtlService;
import transaction.TransactionManager;

public class SubscriptiondtlServiceProxy implements Subscription_dtlService{
	private Subscription_dtlService subscription_dtlService;
	public SubscriptiondtlServiceProxy(){
		subscription_dtlService=(Subscription_dtlService)ObjectFactory.getObject("subscriptiondtlServiceTarget");
	}
	public List<Room>  showroom(Subscription_dtl subscription_dtl) {
		
		TransactionManager tran=(TransactionManager) ObjectFactory.getObject("transaction");
		List<Room> rooms=null;
		try {
			tran.beginTransaction();
			rooms=subscription_dtlService.showroom(subscription_dtl);
			tran.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tran.rollback();
		}
		return rooms;
	}
	public void insert(Subscription_dtl subscription_dtl,Integer id,String[] str) {
		TransactionManager tran=(TransactionManager) ObjectFactory.getObject("transaction");		
		try {
			tran.beginTransaction();
			subscription_dtlService.insert(subscription_dtl,id,str);
			tran.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tran.rollback();
		}
	
	
	}
	public List<Subscription_dtl> show(Integer id) {
		
		TransactionManager tran=(TransactionManager) ObjectFactory.getObject("transaction");
		List<Subscription_dtl> Subscription_dtls=null;
		try {
			tran.beginTransaction();
			Subscription_dtls=subscription_dtlService.show(id);
			tran.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tran.rollback();
		}
		return Subscription_dtls;
	}
	public void delete(Integer id) {
		//System.out.println(2+" "+id);
		TransactionManager tran=(TransactionManager) ObjectFactory.getObject("transaction");		
		try {
			tran.beginTransaction();
			subscription_dtlService.delete(id);
			tran.commit();			
		} catch (Exception e) {
			e.printStackTrace();
			tran.rollback();
		}
	}

}
