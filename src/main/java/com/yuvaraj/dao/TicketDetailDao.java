package com.yuvaraj.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.yuvaraj.model.Department;
import com.yuvaraj.model.EmployeeDetail;
import com.yuvaraj.model.TicketDetail;
import com.yuvaraj.model.UserDetail;
import com.yuvaraj.util.ConnectionUtil;

public class TicketDetailDao {
JdbcTemplate jdbcTemplate=ConnectionUtil.getJdbcTemplate();
public int save(TicketDetail ticketDetail)
{
	String sql="insert into ticket_details(id,user,department,subject,description,assigned_to,created_time,modified_time)values (?,?,?,?,?,?,?,?)";
	Object[] params={ticketDetail.getId(),ticketDetail.getUserId().getId(),ticketDetail.getDepartmentId().getId(),ticketDetail.getSubject()
			,ticketDetail.getDescription(),ticketDetail.getAssignedTo().getId(),ticketDetail.getCreatedTime(),ticketDetail.getModifiedTime()};
	return (jdbcTemplate.update(sql,params));
	}
public int delete(int id) {
	String sql = "delete from ticket_details where id =?";
	Object[] params = { id };
	return (jdbcTemplate.update(sql, params));
}
public int update(int id,int userId,String status) {
	String sql = "update ticket_Details set subject=? where id =? and user=?";
	Object[] params = { status,id,userId };
	return (jdbcTemplate.update(sql, params));
}
public int closeTicket(int id){
	String sql="update ticket_details set status=? where id=?";
	Object[] params={"closed",id};
	return jdbcTemplate.update(sql,params);
}
public int assignTicket(int ticketId,int employeeId ,LocalDateTime time){
	String sql="update ticket_details set assigned_to=?,modified_time=? where id=? and status=?";
	Object[] params={employeeId,time,ticketId,"open"};
	return jdbcTemplate.update(sql,params);
}
public int reassignTicket(int ticketId,int employeeId ){
	String sql="update ticket_details set assigned_to=? where id=? ";
	Object[] params={employeeId,ticketId};
	return jdbcTemplate.update(sql,params);
}
public List<TicketDetail> select(int userId) {
	String sql="select *from ticket_details where user=?";
	Object[] params={userId};
	return jdbcTemplate.query(sql,params,(rs,rownum)->{
		TicketDetail ticketDetail= new TicketDetail();
		ticketDetail.setId(rs.getInt("id"));
		
		UserDetail userDetail=new UserDetail();
		userDetail.setId(rs.getInt("user"));
		ticketDetail.setUserId(userDetail);
		
		Department department=new Department();
		department.setId(rs.getInt("department"));
		ticketDetail.setDepartmentId(department);
		
		ticketDetail.setSubject(rs.getString("subject"));
		ticketDetail.setDescription(rs.getString("description"));
		 
		EmployeeDetail employeeDetail=new EmployeeDetail();
		employeeDetail.setId(rs.getInt("assigned_to"));
		ticketDetail.setAssignedTo(employeeDetail);
		
		ticketDetail.setCreatedTime(rs.getTimestamp("created_time").toLocalDateTime());
		ticketDetail.setStatus(rs.getString("status"));
		ticketDetail.setModifiedTime(rs.getTimestamp("modified_time").toLocalDateTime());
		
		
		
		return ticketDetail;
		
	});
}
public TicketDetail selectOne(int id) {
	String sql="select *from ticket_details where id=?";
	Object[] params={id};
	return jdbcTemplate.queryForObject(sql,params,(rs,rownum)->{
		TicketDetail ticketDetail= new TicketDetail();
		ticketDetail.setId(rs.getInt("id"));
		
		UserDetail userDetail=new UserDetail();
		userDetail.setId(rs.getInt("user"));
		ticketDetail.setUserId(userDetail);
		
		Department department=new Department();
		department.setId(rs.getInt("department"));
		ticketDetail.setDepartmentId(department);
		
		ticketDetail.setSubject(rs.getString("subject"));
		ticketDetail.setDescription(rs.getString("description"));
		 
		EmployeeDetail employeeDetail=new EmployeeDetail();
		employeeDetail.setId(rs.getInt("assigned_to"));
		ticketDetail.setAssignedTo(employeeDetail);
		
		ticketDetail.setCreatedTime(rs.getTimestamp("created_time").toLocalDateTime());
		ticketDetail.setStatus(rs.getString("status"));
		ticketDetail.setModifiedTime(rs.getTimestamp("modified_time").toLocalDateTime());
		
		
		
		return ticketDetail;
		
	});
}
}
