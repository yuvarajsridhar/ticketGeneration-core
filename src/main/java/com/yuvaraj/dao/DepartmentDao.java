package com.yuvaraj.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.yuvaraj.model.Department;
import com.yuvaraj.util.ConnectionUtil;

public class DepartmentDao {
JdbcTemplate jdbcTemplate=ConnectionUtil.getJdbcTemplate();
public int save(Department department)
{
	String sql="insert into seed_department(id,name)values (?,?)";
	Object[] params={department.getId(),department.getName()};
	return (jdbcTemplate.update(sql,params));
	}
public int delete(int id) {
	String sql = "delete from seed_department where id =?";
	Object[] params = { id };
	return (jdbcTemplate.update(sql, params));
}
public List<Department> select() {
	String sql="select *from  seed_department";
	return jdbcTemplate.query(sql,(rs,rownum)->{
		final  Department department = new Department();
		department.setId(rs.getInt("id"));	
		department.setName(rs.getString("name"));
		department.setActive(rs.getBoolean("active"));
		return department;
		
	});
}
public Department selectOne(int id) {
	String sql="select *from  seed_department where id=?";
	return jdbcTemplate.queryForObject(sql,(rs,rownum)->{
		final  Department department = new Department();
		department.setId(rs.getInt("id"));	
		department.setName(rs.getString("name"));
		department.setActive(rs.getBoolean("active"));
		return department;
		
	});
}
}
