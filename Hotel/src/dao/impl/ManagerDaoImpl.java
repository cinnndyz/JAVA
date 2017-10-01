package dao.impl;

import java.util.ArrayList;
import java.util.List;

import rowmapper.ManagerDaoMapper;

import util.JdbcTemplate;
import dao.ManagerDao;
import entity.Manager;


public class ManagerDaoImpl implements ManagerDao{
	private JdbcTemplate jdbcTemplate;
	public ManagerDaoImpl(){
		jdbcTemplate=new JdbcTemplate();
	}		
	public Manager selectByUsernameAndPassword(String username, String pwd) {
		
		String sql=new StringBuffer()
		.append("select * ")
		.append("from manager ")
		.append("where username=? ")
		.append("and pwd=? ")
		.toString();
		
		List<Manager> managers=jdbcTemplate.query(sql, new Object[]{username,pwd}, new ManagerDaoMapper());
		//System.out.println(managers.size());
		return managers.size()==0?null:managers.get(0);
		//return null;
	}

}
