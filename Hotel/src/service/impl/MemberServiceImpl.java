package service.impl;

import constant.Constant;
import dao.MemberDao;
import entity.Member;
import exception.DuplicateUsernameException;
import exception.UserDisabledException;
import exception.UserNotFoundException;
import factory.ObjectFactory;
import service.MemberService;
import util.MD5Util;

public class MemberServiceImpl implements MemberService{

	public Member login(String username, String password) throws UserNotFoundException, UserDisabledException {
		MemberDao memberDao=(MemberDao) ObjectFactory.getObject("memberDao");
		Member member=memberDao.selectByUsernameAndPassword(username, MD5Util.md5(password));
		if(member==null){
			throw new UserNotFoundException("用户名或密码错误");
		}
		if(Constant.USER_STATUS_DISABLE.equals(member.getStatus())){
			throw new UserDisabledException("用户已被禁用");
		}
		
		return member;
	}

	public void regist(Member member) throws DuplicateUsernameException {
		MemberDao memberDao=(MemberDao)ObjectFactory.getObject("memberDao");
		Member m=memberDao.selectByUsername(member.getUsername());
		if(m!=null){
			throw new DuplicateUsernameException("用户名已存在");
		}
		member.setStatus(Constant.USER_STATUS_ENABLE);
		member.setPwd(MD5Util.md5(member.getPwd()));
		memberDao.insert(member);
	}

	public void validateUsername(String username) throws DuplicateUsernameException {
		// TODO Auto-generated method stub
		
	}

}
