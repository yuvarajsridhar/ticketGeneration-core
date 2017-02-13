package com.yuvaraj.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.yuvaraj.model.Department;
import com.yuvaraj.model.EmployeeDetail;
import com.yuvaraj.model.Role;
import com.yuvaraj.util.ConnectionUtil;

public class EmployeeDetailDao {
 JdbcTemplate jdbcTemplate= ConnectionUtil.getJdbcTemplate();
 public int save(EmployeeDetail employeeDetail)
{
	String sql=" insert into seed_employee_details(id,name,email_id,password,department,role)values (?,?,?,?,?,?)";
	Object[] params={employeeDetail.getId(),employeeDetail.getName(),employeeDetail.getEmailId(),employeeDetail.getPassword(),
			employeeDetail.getDepartment().getId(),employeeDetail.getRole().getId()};
	return (jdbcTemplate.update(sql,params));
	}
 public int delete(int id) {
	String sql = "delete from seed_employee_details where id =?";
	Object[] params = { id };
	return (jdbcTemplate.update(sql, params));
}
 public int update(int id,String password) {
	String sql = "update seed_employee_details set password=?  where id =?";
	Object[] params = {password, id };
	return (jdbcTemplate.update(sql, params));
}
 public List<EmployeeDetail> select() {
	String sql="select *from seed_employee_details";
	return jdbcTemplate.query(sql,(rs,rownum)->{
		final  EmployeeDetail employeeDetail = new EmployeeDetail();
		employeeDetail.setId(rs.getInt("id"));
		employeeDetail.setName(rs.getString("name"));
		employeeDetail.setEmailId(rs.getString("email"));
		employeeDetail.setPassword(rs.getString("password"));
		Department department=new Department();
		department.setId(rs.getInt("departname"));
		employeeDetail.setDepartment(department);
		employeeDetail.setActive(rs.getBoolean("active"));
		Role role=new Role();
		role.setId(rs.getInt("role"));
		employeeDetail.setRole(role);
		return employeeDetail;
		
	});
 }
 public EmployeeDetail selectOne(String emailid) {
		String sql="select * from seed_employee_details where email_id=?";
		Object[] params={emailid};
		return jdbcTemplate.queryForObject(sql,params,(rs,rownum)->{
			  EmployeeDetail employeeDetail = new EmployeeDetail();
			employeeDetail.setId(rs.getInt("id"));
			employeeDetail.setName(rs.getString("name"));
			employeeDetail.setEmailId(rs.getString("email_id"));
			employeeDetail.setPassword(rs.getString("password"));
			Department department=new Department();
			department.setId(rs.getInt("department"));
			employeeDetail.setDepartment(department);
			employeeDetail.setActive(rs.getBoolean("active"));
			return employeeDetail;
			
		});
	 }
 
}
