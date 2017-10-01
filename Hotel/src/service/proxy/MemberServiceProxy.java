package service.proxy;


import entity.Member;
import exception.DataAccessException;
import exception.DuplicateUsernameException;
import exception.ServiceException;
import exception.UserDisabledException;
import exception.UserNotFoundException;
import factory.ObjectFactory;
import service.MemberService;
import transaction.TransactionManager;


public class MemberServiceProxy implements MemberService{
	private MemberService memberService;
	public MemberServiceProxy(){
		memberService=(MemberService) ObjectFactory.getObject("memberServiceTarget");
	}
	public void regist(Member member) throws DuplicateUsernameException {
		TransactionManager tran=(TransactionManager) ObjectFactory.getObject("transaction");
		try {
			tran.beginTransaction();
			memberService.regist(member);
			tran.commit();
		} catch (DataAccessException e) {
			tran.rollback();
			throw new ServiceException(e);
		} catch (DuplicateUsernameException e) {
			tran.rollback();
			throw e;
		}
		
	}
	public Member login(String username, String password) throws UserNotFoundException, UserDisabledException {
		Member member=null;
		TransactionManager tran=(TransactionManager) ObjectFactory.getObject("transaction");
		try {
			tran.beginTransaction();
			
			member=memberService.login(username, password);
			
			tran.commit();
		} catch (DataAccessException e) {
			tran.rollback();
			throw new ServiceException(e);
		} catch (UserNotFoundException e) {
			tran.rollback();
			throw e;
		} catch (UserDisabledException e) {
			tran.rollback();
			throw e;
		}		
		return member;
	}
	public void validateUsername(String username) throws DuplicateUsernameException {
		// TODO Auto-generated method stub
		
	}

}
