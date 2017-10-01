package service.impl;

import java.util.List;

import dao.Subscription_dtlDao;
import entity.Room;
import entity.Subscription;
import entity.Subscription_dtl;
import factory.ObjectFactory;
import service.Subscription_dtlService;

public class SubscriptiondtlServiceImpl implements Subscription_dtlService{

	public List<Room>  showroom(Subscription_dtl subscription_dtl) {
		
		Subscription_dtlDao subscription_dtlDao=(Subscription_dtlDao)ObjectFactory.getObject("subscriptiondtlDao");
		List<Room> rooms=subscription_dtlDao.showroom(subscription_dtl);
		return rooms;
	}

	public void insert(Subscription_dtl subscription_dtl,Integer id,String[] str) {
		
		Subscription_dtlDao subscription_dtlDao=(Subscription_dtlDao)ObjectFactory.getObject("subscriptiondtlDao");
		subscription_dtlDao.insert(subscription_dtl,id,str);
	}

	public List<Subscription_dtl> show(Integer id) {
		
		Subscription_dtlDao subscription_dtlDao=(Subscription_dtlDao)ObjectFactory.getObject("subscriptiondtlDao");
		
		List<Subscription_dtl> Subscription_dtls=subscription_dtlDao.show(id);
		return Subscription_dtls;
	}

	public void delete(Integer id) {
		//System.out.println(3+" "+id);
		Subscription_dtlDao subscription_dtlDao=(Subscription_dtlDao)ObjectFactory.getObject("subscriptiondtlDao");
		subscription_dtlDao.delete(id);
	}

}
