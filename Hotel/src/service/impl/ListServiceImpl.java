package service.impl;

import java.util.Date;
import java.util.List;

import dao.ListDao;

import entity.Member;
import entity.Subscription;
import entity.Subscription_dtl;
import factory.ObjectFactory;
import service.ListService;

public class ListServiceImpl implements ListService{

	public List<Subscription> list(Integer rootType, String status, String startDate, String endDate, String no, String username) {
		ListDao listDao=(ListDao)ObjectFactory.getObject("listDao");
		List<Subscription> Subscriptions=listDao.list(rootType,status,startDate,endDate,no,username);
		return Subscriptions;
	}

	public Subscription select(Integer id) {
		ListDao listDao=(ListDao)ObjectFactory.getObject("listDao");
		Subscription subscription=listDao.select(id);		
		return subscription;
	}

	public Member selectMemeber(Integer mid) {
		
		ListDao listDao=(ListDao)ObjectFactory.getObject("listDao");
		Member member=listDao.selectMember(mid);
		return member;
	}

	public List<Subscription_dtl> selectSubscription_dtl(Integer id) {
		ListDao listDao=(ListDao)ObjectFactory.getObject("listDao");
		List<Subscription_dtl> Subscription_dtls=listDao.selectSubscription_dtl(id);
		return Subscription_dtls;
	}

	public void update(Integer id, String status, String str) {
		
		ListDao listDao=(ListDao)ObjectFactory.getObject("listDao");
		listDao.update(id,status,str);
	}

	public List<Subscription_dtl> selectId(Integer sid) {
		
		ListDao listDao=(ListDao)ObjectFactory.getObject("listDao");
		List<Subscription_dtl> Subscription_dtls=listDao.selectId(sid);
		return Subscription_dtls;
	} 
	
}
