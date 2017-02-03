package com.yuvaraj.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.yuvaraj.model.UserDetail;
import com.yuvaraj.util.ConnectionUtil;

public class UserDetailDao {
 JdbcTemplate jdbcTemplate=ConnectionUtil.getJdbcTemplate();
 public int save(UserDetail userDetail)
{
	String sql="insert into seed_user_details(id,name,email_id,password)values (?,?,?,?)";
	Object[] params={userDetail.getId(),userDetail.getName(),userDetail.getEmailId(),userDetail.getPassword()};
	return (jdbcTemplate.update(sql,params));
	}
 public int delete(int id) {
	String sql = "delete from seed_user_details where id =?";
	Object[] params = { id };
	return (jdbcTemplate.update(sql, params));
	}
 public int update(int id,String password){
	 String sql="update seed_user_details set password=? where id=?";
	 Object[] params={password,id};
	 return jdbcTemplate.update(sql,params);
 }
 public List<UserDetail> select() {
	String sql="select *from seed_user_details ";
	return jdbcTemplate.query(sql,(rs,rownum)->{
		final UserDetail userDetail = new UserDetail();
		userDetail.setId(rs.getInt("id"));
		userDetail.setName(rs.getString("name"));
		userDetail.setEmailId(rs.getString("email_id"));
	     userDetail.setPassword(rs.getString("password"));
	     userDetail.setActive(rs.getBoolean("active"));
		
		return userDetail;
		
	});
	
}
 public UserDetail selectOne(String email) {
		String sql="select *from seed_user_details where email_id=? ";
		Object[] params={email};
		return jdbcTemplate.queryForObject(sql,params,(rs,rownum)->{
			final UserDetail userDetail = new UserDetail();
			userDetail.setId(rs.getInt("id"));
			userDetail.setName(rs.getString("name"));
			userDetail.setEmailId(rs.getString("email_id"));
		     userDetail.setPassword(rs.getString("password"));
		     userDetail.setActive(rs.getBoolean("active"));
			
			return userDetail;
			
		});
}
 public int userRegestration(UserDetail userDetail){
	 String sql="insert into seed_user_details(id,name,email_id,password)values (?,?,?,?)";
		Object[] params={userDetail.getId(),userDetail.getName(),userDetail.getEmailId(),userDetail.getPassword()};
		return (jdbcTemplate.update(sql,params));
 }

}