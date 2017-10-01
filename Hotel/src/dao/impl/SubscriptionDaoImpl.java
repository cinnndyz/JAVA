package dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import resultsetextrator.Subscription_dtlResultSetExtrator;
import rowmapper.MemberRowMapper;
import rowmapper.SubscriptionRowMapper;
import rowmapper.Subscription_dtlRowMapper;

import util.JdbcTemplate;
import dao.SubscriptionDao;
import entity.Subscription;
import entity.Subscription_dtl;

public class SubscriptionDaoImpl implements SubscriptionDao{
	private JdbcTemplate jdbcTemplate;
	public SubscriptionDaoImpl(){
		jdbcTemplate=new JdbcTemplate();
	}
	public void regist(Subscription subscription) {
		
		String no=getNo();
		String sql=new StringBuffer()
			.append("insert into subscription ")
			.append(" (mid,linkman,phone,email,cretime,no,status) ")
			.append("values ")
			.append(" (?,?,?,?,?,?,?) ")
			.toString();
		
		jdbcTemplate.update(sql, new Object[]{subscription.getMid(),subscription.getLinkman(),subscription.getPhone(),subscription.getEmail(),new Timestamp(new Date().getTime()),no,1});
	}
	public synchronized String getNo(){
		Random r=new Random();
		Integer i=r.nextInt(10000);
		return new Date().getTime()+i.toString();
	}
	public List<Subscription> show(int id) {
		
		String sql=new StringBuffer()
			.append("select * ")
			.append("from subscription ")
			.append("where mid=?")
			.toString();
		List<Subscription> subscriptions=jdbcTemplate.query(sql, new Object[]{id}, new SubscriptionRowMapper());
		return subscriptions;
	}
	public List<Subscription> showmessage(int id) {
		
		String sql=new StringBuffer()
			.append("select * ")
			.append("from subscription ")
			.append("where id=?")
			.toString();
		
		List<Subscription> subscriptions=jdbcTemplate.query(sql, new Object[]{id}, new SubscriptionRowMapper());
		
		return subscriptions;
	}
	public void modifymessage(Subscription subscription) {
	
		String sql=new StringBuffer()
			.append("update subscription set ")
			.append(" linkman=?,phone=?,email=? ")
			.append(" where id=? ")
			.toString();
		jdbcTemplate.update(sql, new Object[]{subscription.getLinkman(),subscription.getPhone(),subscription.getEmail(),subscription.getId()});
		
	}
	
	public List<Subscription_dtl> select(Integer id) {

		List<Subscription_dtl> Subscription_dtls=new ArrayList<Subscription_dtl>(); 
		String sql=new StringBuffer()
			.append("select * ")
			.append("from subscription_dtl ")
			.append("where sid=? ")
			.toString();
		Subscription_dtls=jdbcTemplate.query(sql, new Object[]{id}, new Subscription_dtlRowMapper());	
		
		return Subscription_dtls;
	}
	public void delete(Integer id) {
		
		String sql=new StringBuffer()
			.append("delete ")
			.append("from subscription ")
			.append("where id=? ")
			.toString();
		jdbcTemplate.update(sql, new Object[]{id});
	}
	public List<Subscription> showhistory(int id) {
		String sql=new StringBuffer()
		.append("select * ")
		.append("from subscription ")
		.append("where mid=? and status not in('1') ")
		.toString();
	List<Subscription> subscriptions=jdbcTemplate.query(sql, new Object[]{id}, new SubscriptionRowMapper());
	return subscriptions;
	}
}
