package dao;

import entity.Manager;


public interface ManagerDao {
	public Manager selectByUsernameAndPassword(String username,String pwd);
}
