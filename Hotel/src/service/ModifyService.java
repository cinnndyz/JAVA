package service;

import entity.Member;
import exception.DuplicateUsernameException;

public interface ModifyService {
	public void modify(Member member);
	public void modifyPwd(Member member);
}
