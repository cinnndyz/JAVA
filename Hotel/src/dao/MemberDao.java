package dao;

import entity.Member;





public interface MemberDao {
	//根据用户名查询一个用户
	public Member selectByUsername(String username);
	
	//保存一个用户
	public void insert(Member member);

	//根据用户名和密码查询一个用户
	public Member selectByUsernameAndPassword(String username,String pwd);
}
