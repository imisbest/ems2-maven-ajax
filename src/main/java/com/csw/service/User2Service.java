package com.csw.service;

import com.csw.entity.User2;

public interface User2Service {

	User2 login(String username, String password);

	Boolean addUser(User2 user2);
	User2 queryBy(String username);

}
