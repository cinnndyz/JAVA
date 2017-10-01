package dao.impl;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import rowmapper.MemberRowMapper;
import rowmapper.RoomRowMapper;
import rowmapper.Subscription00RowMapper;
import rowmapper.SubscriptionRowMapper;
import rowmapper.Subscription_dtlRowMapper;

import util.JdbcTemplate;

import dao.ListDao;
import entity.Member;
import entity.Subscription;
import entity.Subscription_dtl;

public class ListDaoImpl implements ListDao{
	private JdbcTemplate jdbcTemplate;
	public ListDaoImpl(){
		jdbcTemplate=new JdbcTemplate();
	}
	public List<Subscription> list(Integer rootType, String status, String startDate, String endDate, String no, String username) {		
		List<Subscription> Subscriptions=new ArrayList<Subscription>();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date sDate=null;
		Date eDate=null;
	
		if(startDate!=""){
			try {
				sDate=sdf.parse(startDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}		
		if(endDate!=""){
			try {
				eDate=sdf.parse(endDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		StringBuffer s=new StringBuffer()
				.append("select s.id,s.no,s.linkman,s.email,s.phone,s.status,s.mid ")
				.append("from subscription s ")
				.append("left join subscription_dtl sd on sd.sid=s.id ")
				.append("left join room r on r.id=sd.rid ")
				.append("left join member m on m.id=s.mid ")
				.append("where 1=1 ");
		if(rootType!=0){
			s.append("and r.cid=? ");
		}		
		if(!status.equals("0")){
			s.append("and s.status=? ");
		}
		
		if(sDate!=null){
			s.append("and sd.sdate>=? ");
		}
		if(endDate!=""){
			s.append("and sd.edate<=? ");
		}
		
		if(no!=""){
			s.append("and s.no=? ");
		}		
		if(username!=""){
			s.append("and m.username=? ");	
		}
		String sql=s.append("group by s.id ")
					.append("order by s.cretime desc")
								.toString();
		ArrayList list=new ArrayList();
		if(rootType!=0){
			list.add(rootType);
		}
		if(!status.equals("0")){
			list.add(status);
		}
		if(sDate!=null){
			list.add(sDate);
		}
		if(eDate!=null){
			list.add(eDate);
		}
		if(no!=""){
			list.add(no);
		}
		if(username!=""){
			list.add(username);
		}
		Object[] objects=new Object[list.size()];
		for (int i = 0; i < list.size(); i++) {
			objects[i]=list.get(i);
		}
			
		Subscriptions=jdbcTemplate.query(sql, objects, new Subscription00RowMapper());
		
		return Subscriptions;
	}
	public Subscription select(Integer id) {
		String sql=new StringBuffer()
			.append("select *  ")
			.append("from subscription ")
			.append("where id=? ")
			.toString();
		List<Subscription> subscriptions=jdbcTemplate.query(sql, new Object[]{id}, new SubscriptionRowMapper());
		return subscriptions.size()==0?null:subscriptions.get(0);
	}
	public Member selectMember(Integer mid) {
		
		String sql=new StringBuffer()
			.append("select * ")
			.append("from member ")
			.append("where id=?")
			.toString();
		List<Member> members=jdbcTemplate.query(sql, new Object[]{mid}, new MemberRowMapper());
		
		return members.size()==0?null:members.get(0);
	}
	public List<Subscription_dtl> selectSubscription_dtl(Integer id) {
		String sql=new StringBuffer()
			.append("select * ")
			.append("from subscription_dtl ")
			.append("where sid=?")
			.toString();
		List<Subscription_dtl> subscription_dtls=jdbcTemplate.query(sql, new Object[]{id}, new Subscription_dtlRowMapper());
		return subscription_dtls;
	}
	public void update(Integer id, String status, String str) {
		String sql=new StringBuffer()
			.append("update subscription set ")
			.append("status=?,remark=? ")
			.append("where id=? ")
			.toString();
		jdbcTemplate.update(sql, new Object[]{status,str,id});
	}
	public List<Subscription_dtl> selectId(Integer sid) {
		
		String sql=new StringBuffer()
		.append("select * ")
		.append("from subscription_dtl ")
		.append("where sid=? ")
		.toString();
		List<Subscription_dtl> Subscription_dtls=jdbcTemplate.query(sql, new Object[]{sid}, new Subscription_dtlRowMapper());
		return Subscription_dtls;
	}

}
