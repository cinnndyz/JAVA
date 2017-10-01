package form;

import org.apache.struts.action.ActionForm;

import entity.User;

public class UserForm extends ActionForm{
	private User user=new User();//private

	public User getUser() {//public
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
