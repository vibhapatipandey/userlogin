package com.app.user.login.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	public List<String> getUserName(){
		List<String> userList=new ArrayList<>();
		userList.addAll(jdbcTemplate.queryForList("select username from users;", String.class));
		return userList;
	}

}
