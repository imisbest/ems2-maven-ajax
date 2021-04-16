package com.csw.dao;

import com.csw.entity.User2;
import org.apache.ibatis.annotations.Param;

public interface User2Dao {

	User2 queryByUsernameAndPassword(String username, String password);

	Integer addUser(User2 user2);
	User2 queryBy(@Param("username") String username);

}
