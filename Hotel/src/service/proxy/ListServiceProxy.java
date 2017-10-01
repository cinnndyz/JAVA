package service.proxy;

import java.util.Date;
import java.util.List;

import entity.Member;
import entity.Subscription;
import entity.Subscription_dtl;
import factory.ObjectFactory;
import service.ListService;
import transaction.TransactionManager;

public class ListServiceProxy implements ListService{
	private ListService listService;
	public ListServiceProxy(){
		listService=(ListService)ObjectFactory.getObject("listServiceTarget");
	}
	public List<Subscription> list(Integer rootType, String status, String startDate, String endDate, String no, String username) {
		
		TransactionManager tran=(TransactionManager) ObjectFactory.getObject("transaction");
		List<Subscription> Subscriptions=null;
		try {
			tran.beginTransaction();
			Subscriptions=listService.list(rootType, status, startDate, endDate, no, username);
			tran.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tran.rollback();
		}		
		return Subscriptions;
	}
	public Subscription select(Integer id) {
		Subscription subscription=null;
		TransactionManager tran=(TransactionManager) ObjectFactory.getObject("transaction");
		try {
			tran.beginTransaction();
			subscription=listService.select(id);
			tran.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tran.rollback();
		}
		return subscription;
	}
	public Member selectMemeber(Integer mid) {
		
		Member member=null;
		TransactionManager tran=(TransactionManager) ObjectFactory.getObject("transaction");
		try {
			tran.beginTransaction();
			member=listService.selectMemeber(mid);
			tran.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tran.rollback();
		}
		return member;
	}
	public List<Subscription_dtl> selectSubscription_dtl(Integer id) {
		List<Subscription_dtl> Subscription_dtls=null;
		TransactionManager tran=(TransactionManager) ObjectFactory.getObject("transaction");
		try {
			tran.beginTransaction();
			Subscription_dtls=listService.selectSubscription_dtl(id);
			tran.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tran.rollback();
		}		
		return Subscription_dtls;
	}
	public void update(Integer id, String status, String str) {
		TransactionManager tran=(TransactionManager) ObjectFactory.getObject("transaction");
		try {
			tran.beginTransaction();
			listService.update(id, status, str);
			tran.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tran.rollback();
		}
		
	}
	public List<Subscription_dtl> selectId(Integer sid) {
		
		TransactionManager tran=(TransactionManager) ObjectFactory.getObject("transaction");
		List<Subscription_dtl> Subscription_dtls=null;
		try {
			tran.beginTransaction();
			Subscription_dtls=listService.selectId(sid);
			tran.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tran.rollback();
		}
		return Subscription_dtls;
	}

}
