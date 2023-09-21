package com.app.user.login.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.app.user.login.pojo.User;

@Repository
public class UserRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	class UserRowMapper implements RowMapper<User>{

		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {

			return User.builder().userID(rs.getInt("USERID")).userName(rs.getString("USERNAME"))
					.password(rs.getString("PASSWORD")).userFName(rs.getString("USER_FNAME"))
					.userLName(rs.getString("USER_LNAME")).userDOB(rs.getDate("USER_DOB").toString())
					.dptName(rs.getString("USER_DPT_NAME")).traningName(rs.getString("USER_TRAINING_NAME")).build();
		}

	}
	
	
	public boolean isUserExists(String username) {
        String sql = "SELECT count(*) FROM USERS WHERE userName = ?";
	boolean result = false;
	var count = jdbcTemplate.queryForObject( sql, new Object[] { username }, Integer.class);
	if (count > 0) {
		result = true;
	}
	return result;
  }
	
	

	/*public boolean isUserExists(User user) {
		String username= user.getUserName(); 
		String password= user.getPassword();
		System.out.println("username  "+username +"    password  "+password);
        String sql = "SELECT username, password FROM USERS WHERE userName = ? and password=?";
	boolean result = false;
	var dbUser =jdbcTemplate.queryForObject( sql, new Object[] { username, password }, new UserRowMapper());
	System.out.println("==========="+ dbUser.getUserName());
	if (dbUser.getUserName().equals(username)&&dbUser.getPassword().equals(password)) {
		result = true;
	}
	return result;
  }*/
	
	
	
	public int createUser(User user) {
        return jdbcTemplate.update("insert into USERS (user_fname, user_lname, user_dob,username,password,user_dpt_name,user_training_name) " 
	          + "values(?, ?, ?, ?, ?, ?, ?)",
            new Object[] {
            		user.getUserFName(), user.getUserLName(), user.getUserDOB(),
            		user.getUserName(),user.getPassword(),user.getDptName(),
            		user.getTraningName()  });
    }
	
	
	public List < User > findAll() {
        return jdbcTemplate.query("select * from USERS", new UserRowMapper());
    }

}
