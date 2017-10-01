package dao.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import resultsetextrator.MemberResultSetExtrator;
import rowmapper.MemberRowMapper;

import dao.MemberDao;
import util.JdbcTemplate;
import entity.Member;

public class MemberDaoImpl implements MemberDao{
	private JdbcTemplate jdbcTemplate;
	public MemberDaoImpl(){
		jdbcTemplate=new JdbcTemplate();
	}
	public void insert(Member member) {
		String sql=new StringBuffer()
			.append("insert into member ")
			.append(" (username,pwd,name,email,phone,regtime) ")
			.append("values ")
			.append(" (?,?,?,?,?,?)")
			.toString();
		jdbcTemplate.update(sql, new Object[]{member.getUsername(),member.getPwd(),member.getName(),member.getEmail(),member.getPhone(),new Timestamp(new Date().getTime())});
	}

	public Member selectByUsername(String username) {
		String sql=new StringBuffer()
			.append("select * ")
			.append("from member ")
			.append("where username=? ")
			.toString();
		return (Member)jdbcTemplate.query(sql,new Object[]{username},new MemberResultSetExtrator());
	}

	public Member selectByUsernameAndPassword(String username, String pwd) {
		String sql=new StringBuffer()
			.append("select * ")
			.append("from member ")
			.append("where username=? ")
			.append("and pwd=? ")
			.toString();
		List<Member> members=jdbcTemplate.query(sql, new Object[]{username,pwd}, new MemberRowMapper());
		return members.size()==0?null:members.get(0);
	}

}
