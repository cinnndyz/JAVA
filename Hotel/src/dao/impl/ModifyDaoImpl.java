package dao.impl;

import util.JdbcTemplate;
import util.MD5Util;
import dao.ModifyDao;
import entity.Member;

public class ModifyDaoImpl implements ModifyDao{
	private JdbcTemplate jdbcTemplate;
	public ModifyDaoImpl(){
		jdbcTemplate=new JdbcTemplate();
	}
	public void modify(Member member) {
		String sql=new StringBuffer()
			.append("update member set ")
			.append(" name=?,phone=?,email=? ")
			.append(" where id=?")
			.toString();
		
		jdbcTemplate.update(sql,new Object[]{member.getName(),member.getPhone(),member.getEmail(),member.getId()});
	}
	public void modifyPwd(Member member) {
		
		String sql=new StringBuffer()
			.append("update member set ")
			.append("pwd=? ")
			.append(" where id=?")
			.toString();
		
		jdbcTemplate.update(sql,new Object[]{MD5Util.md5(member.getPwd()),member.getId()});
	}


}
