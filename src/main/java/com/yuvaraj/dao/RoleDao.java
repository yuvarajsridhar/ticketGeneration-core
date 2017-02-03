package com.yuvaraj.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.yuvaraj.model.Role;
import com.yuvaraj.util.ConnectionUtil;

public class RoleDao {
JdbcTemplate jdbcTemplate=ConnectionUtil.getJdbcTemplate();
public int save(Role role)
{
	String sql="insert into seed_role(id,name)values (?,?)";
	Object[] params={role.getId(),role.getName()};
	return (jdbcTemplate.update(sql,params));
	}
public int delete(int id) {
	String sql = "delete from seed_role where id =?";
	Object[] params = { id };
	return (jdbcTemplate.update(sql, params));
}
public int update(int id) {
	String sql = "update seed_role where id =?";
	Object[] params = { id };
	return (jdbcTemplate.update(sql, params));
}
public List<Role> select() {
	String sql="select *from Seed_role ";
	return jdbcTemplate.query(sql,(rs,rownum)->{
		final  Role role = new Role();
		role.setId(rs.getInt("id"));
		role.setName(rs.getString("name"));
		return role;
		
	});
	
}
public  Role selectOne(int id) {
	String sql="select *from Seed_role where id=? ";
	return jdbcTemplate.queryForObject(sql,(rs,rownum)->{
		final  Role role = new Role();
		role.setId(rs.getInt("id"));
		role.setName(rs.getString("name"));
		return role;
		
	});
	
}
}
