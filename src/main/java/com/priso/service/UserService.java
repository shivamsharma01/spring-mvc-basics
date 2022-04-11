package com.priso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.priso.dao.UserDAO;
import com.priso.model.User;

@Service
public class UserService {

	@Autowired
	private UserDAO userDAO;

	public int createUser(User user) {
		return userDAO.saveUser(user);
	}

}
