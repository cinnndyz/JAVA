package dao;

import java.util.List;

import entity.Room;
import entity.Subscription;
import entity.Subscription_dtl;

public interface Subscription_dtlDao {
	public List<Room>  showroom(Subscription_dtl subscription_dtl);
	public void insert(Subscription_dtl subscription_dtl,Integer id,String[] str);
	public List<Subscription_dtl> show(Integer id);
	public void delete(Integer id);
}
