package service;

import entity.Manager;
import exception.UserDisabledException;
import exception.UserNotFoundException;

public interface ManagerService {
	public Manager login(String username,String password) throws UserNotFoundException,UserDisabledException;
}
