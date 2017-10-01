package dao;

import entity.Member;

public interface ModifyDao {
	//修改一个用户
	public void modify(Member member);
	//修改用户密码
	public void modifyPwd(Member member);
}
