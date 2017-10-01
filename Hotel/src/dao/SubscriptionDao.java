package dao;

import java.util.List;

import entity.Subscription;
import entity.Subscription_dtl;

public interface SubscriptionDao {
	public void regist(Subscription subscription);
	public List<Subscription> show(int id);
	public List<Subscription> showmessage(int id);
	public void modifymessage(Subscription subscription);
	public List<Subscription_dtl> select(Integer id);
	public void delete(Integer id);
	public List<Subscription> showhistory(int id);
}
