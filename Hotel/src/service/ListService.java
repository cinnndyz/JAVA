package service;

import java.util.Date;
import java.util.List;

import entity.Member;
import entity.Subscription;
import entity.Subscription_dtl;



public interface ListService {
	public List<Subscription> list(Integer rootType,String status,String startDate,String endDate,String no,String username);
	public Subscription select(Integer id);
	public Member selectMemeber(Integer mid);
	public List<Subscription_dtl> selectSubscription_dtl(Integer id);
	public void update(Integer id,String status,String str);
	public List<Subscription_dtl> selectId(Integer sid);
}
