package service;

import entity.Member;
import exception.DuplicateUsernameException;
import exception.UserDisabledException;
import exception.UserNotFoundException;

public interface MemberService {
	public void regist(Member member)throws DuplicateUsernameException;
	public Member login(String username,String password)throws UserNotFoundException,UserDisabledException;
	public void validateUsername(String username)throws DuplicateUsernameException;
}
