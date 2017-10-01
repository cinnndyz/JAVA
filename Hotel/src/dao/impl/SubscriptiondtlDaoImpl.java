package dao.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import resultsetextrator.RoomResultSetExtrator;
import resultsetextrator.Subscription_dtlResultSetExtrator;
import rowmapper.RoomRowMapper;
import rowmapper.SubscriptionRowMapper;
import rowmapper.Subscription_dtlRowMapper;
import util.JdbcTemplate;
import dao.Subscription_dtlDao;
import entity.Room;
import entity.Subscription;
import entity.Subscription_dtl;

public class SubscriptiondtlDaoImpl implements Subscription_dtlDao{
	private JdbcTemplate jdbcTemplate;
	public SubscriptiondtlDaoImpl(){
		jdbcTemplate=new JdbcTemplate();
	}
	public List<Room>  showroom(Subscription_dtl subscription_dtl) {
		
		List<Room> rooms=null;		
		if(subscription_dtl.getResidetype()==1){
			String sql=new StringBuffer()
			.append("select * from room ")
			.append("where cid=? ")
			.append("and   status='o' ")
			.append("and   id not in ( ")
			.append("select m.rid from ")
			.append("( ")
			.append("select sd.rid,sum(sd.residetype) sum  from reside r ")
			.append("left join  subscription_dtl sd ")
			.append("on r.dtlid= sd.id ")
			.append("where r.residedate between ? and ? ")
			.append("group by sd.rid,sd.residetype,r.residedate ")
			.append(") m where m.sum>=2 ")
			.append(") ")
			.toString();			
			rooms=jdbcTemplate.query(sql, new Object[]{subscription_dtl.getRid(),subscription_dtl.getSdate(),subscription_dtl.getEdate()}, new RoomRowMapper());
			
		}else{
			String sql=new StringBuffer()
			.append("select * from room ")
			.append("where cid=? ")
			.append("and   status='o' ")
			.append("and   id not in ( ")
			.append(" select sd.rid from reside r ")
			.append(" left join  subscription_dtl sd ")
			.append(" on r.dtlid= sd.id ")
			.append(" where r.residedate between ? and ? ")
			.append(" group by sd.rid ")
			.append(") ")
			.toString();
			
			rooms=jdbcTemplate.query(sql, new Object[]{subscription_dtl.getRid(),subscription_dtl.getSdate(),subscription_dtl.getEdate()}, new RoomRowMapper());
			
		}		
		return rooms;
	}
	public void insert(Subscription_dtl subscription_dtl,Integer id,String[] str) {
//		for (int i = 0; i < str.length; i++) {
//			System.out.println(str[i]);
//		}
		List<Room> rooms=new ArrayList<Room>();
		String sql00=null;		
		for (int i = 0; i < str.length; i++) {
			sql00=new StringBuffer()
			.append("select * ")
			.append("from room ")
			.append("where no=? ")
			.toString();
			Room room=(Room)jdbcTemplate.query(sql00, new Object[]{str[i]}, new RoomResultSetExtrator());			
			rooms.add(room);
		}
		
		for (int i = 0; i < rooms.size(); i++) {
			String sql=new StringBuffer()
			.append("insert into subscription_dtl ")
			.append(" (rid,sid,sdate,edate,residetype,price) ")
			.append("values ")
			.append("(?,?,?,?,?,?)")
			.toString();				
			jdbcTemplate.update(sql, new Object[]{rooms.get(i).getId(),id,subscription_dtl.getSdate(),subscription_dtl.getEdate(),subscription_dtl.getResidetype(),subscription_dtl.getPrice()});
		}
		
		List<Subscription_dtl> subscription_dtls=new ArrayList<Subscription_dtl>();
		for (int i = 0; i < rooms.size(); i++) {
			String sql01=new StringBuffer()
			.append("select * from subscription_dtl ")
			.append("where rid=? && sid=? && sdate=? && edate=? && residetype=? && price=?")			
			.toString();
			Subscription_dtl Subscription_dtl=(Subscription_dtl)jdbcTemplate.query(sql01, new Object[]{rooms.get(i).getId(),id,subscription_dtl.getSdate(),subscription_dtl.getEdate(),subscription_dtl.getResidetype(),subscription_dtl.getPrice()}, new Subscription_dtlResultSetExtrator());
			subscription_dtls.add(Subscription_dtl);
		}
		
								
		int day=(int)(subscription_dtl.getEdate().getTime()/1000/60/60/24-subscription_dtl.getSdate().getTime()/1000/60/60/24+1);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(subscription_dtl.getSdate());
		for (int i = 0; i < day; i++) {
		String sql02=new StringBuffer()
			.append("insert into reside ")
			.append(" (dtlid,residedate) ")
			.append("values ")
			.append(" (?,?) ")
			.toString();
		for(int j=0;j<subscription_dtls.size();j++){
			jdbcTemplate.update(sql02, new Object[]{subscription_dtls.get(j).getId(),sdf.format(calendar.getTime())});
		}		
		calendar.add(Calendar.DATE, +1);
		}
	
	}
	public List<Subscription_dtl> show(Integer id) {
		
		List<Subscription_dtl> Subscription_dtls=null;
		String sql=new StringBuffer()
			.append("select * ")
			.append("from subscription_dtl ")
			.append("where sid=? ")
			.toString();
		Subscription_dtls=(List<Subscription_dtl>)jdbcTemplate.query(sql, new Object[]{id}, new Subscription_dtlRowMapper());							
		return Subscription_dtls;
	}
	public void delete(Integer id) {
		//System.out.println(4+" "+id);
		String sql=new StringBuffer()
			.append("delete ")
			.append("from reside ")
			.append("where dtlid=? ")
			.toString();
		//System.out.println(sql);
		jdbcTemplate.update(sql, new Object[]{id});
		String sql01=new StringBuffer()
			.append("delete ")
			.append("from subscription_dtl ")
			.append("where id=? ")
			.toString();
		//System.out.println(sql01);
		jdbcTemplate.update(sql01, new Object[]{id});
	}
	
	

}
