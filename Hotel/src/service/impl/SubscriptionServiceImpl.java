package service.impl;

import java.util.ArrayList;
import java.util.List;

import dao.SubscriptionDao;
import entity.Subscription;
import entity.Subscription_dtl;
import factory.ObjectFactory;
import service.SubscriptionService;

public class SubscriptionServiceImpl implements SubscriptionService{

	public void regist(Subscription subscription) {
		
		SubscriptionDao subscriptionDao=(SubscriptionDao)ObjectFactory.getObject("subscriptionDao");
		subscriptionDao.regist(subscription);
	
	}

	public List<Subscription> show(int id) {
		
		SubscriptionDao subscriptionDao=(SubscriptionDao)ObjectFactory.getObject("subscriptionDao");
		List<Subscription> subscriptions=subscriptionDao.show(id);
		return subscriptions;
	}

	public List<Subscription> showmessage(int id) {
		
		SubscriptionDao subscriptionDao=(SubscriptionDao)ObjectFactory.getObject("subscriptionDao");
		List<Subscription> subscriptions=subscriptionDao.showmessage(id);
		return subscriptions;
	}

	public void modifymessage(Subscription subscription) {
		
		SubscriptionDao subscriptionDao=(SubscriptionDao)ObjectFactory.getObject("subscriptionDao");
		subscriptionDao.modifymessage(subscription);
	}

	public List<Subscription_dtl> select(Integer id) {
	
		SubscriptionDao subscriptionDao=(SubscriptionDao)ObjectFactory.getObject("subscriptionDao");
		List<Subscription_dtl> Subscription_dtls=(List<Subscription_dtl>)subscriptionDao.select(id);
		return Subscription_dtls;
	}

	public void delete(Integer id) {
		
		SubscriptionDao subscriptionDao=(SubscriptionDao)ObjectFactory.getObject("subscriptionDao");
		subscriptionDao.delete(id);
	}

	public List<Subscription> showhistory(int id) {
		SubscriptionDao subscriptionDao=(SubscriptionDao)ObjectFactory.getObject("subscriptionDao");
		List<Subscription> subscriptions=subscriptionDao.showhistory(id);
		return subscriptions;
		
	}
	
}
