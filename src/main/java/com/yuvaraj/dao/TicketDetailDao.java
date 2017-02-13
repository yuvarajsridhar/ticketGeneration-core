package com.yuvaraj.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.commons.mail.EmailException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.sun.xml.internal.ws.api.pipe.ThrowableContainerPropertySet;
import com.yuvaraj.model.Department;
import com.yuvaraj.model.EmployeeDetail;
import com.yuvaraj.model.TicketDetail;
import com.yuvaraj.model.UserDetail;
import com.yuvaraj.util.ConnectionUtil;
import com.yuvaraj.util.Mail;

public class TicketDetailDao {
	   

JdbcTemplate jdbcTemplate=ConnectionUtil.getJdbcTemplate();
public int save(TicketDetail ticketDetail)
{  String sql="insert into ticket_details(id,user,department,subject,description,assigned_to,created_time,modified_time,priority)values (?,?,?,?,?,?,?,?,?)";
Object[] params={ticketDetail.getId(),ticketDetail.getUserId().getId(),ticketDetail.getDepartmentId().getId(),ticketDetail.getSubject()
		,ticketDetail.getDescription(),ticketDetail.getAssignedTo().getId(),ticketDetail.getCreatedTime(),ticketDetail.getModifiedTime(),ticketDetail.getPriority()};
return (jdbcTemplate.update(sql,params));
	}
public int createticket(TicketDetail ticketDetail) throws EmailException{

	UserDetail userDetail=new UserDetail();
try{
	Mail.sendSimpleMail("syuvraj8@gmail.com","your ticket is created successfully and your description is ",ticketDetail.getDescription() );

	String sql="insert into ticket_details(id,user,department,subject,description,created_time,priority )values(?,?,?,?,?,?,?)";
	Object[] params={ticketDetail.getId(),ticketDetail.getUserId().getId(),ticketDetail.getDepartmentId().getId(),ticketDetail.getSubject(),ticketDetail.getDescription(),ticketDetail.getCreatedTime(),ticketDetail.getPriority()};
   return jdbcTemplate.update(sql,params);}
catch(EmailException e){
	throw e;
}
   
}
public int delete(int id,int userId) {
	
	String sql = "delete from ticket_details where id =? and user=?";
	Object[] params = { id,userId };
	return (jdbcTemplate.update(sql, params));
}
public int update(int id,String status) {
	String sql = "update ticket_Details set subject=? where id=?";
	Object[] params = { status,id };
	return (jdbcTemplate.update(sql, params));
}
public int closeTicket(int id){
	String sql="update ticket_details set status=? where id=?";
	Object[] params={"closed",id};
	return jdbcTemplate.update(sql,params);
}
public int assignTicket(int ticketId,int employeeId ,LocalDateTime time){
	String sql="update ticket_details set assigned_to=?,modified_time=?,status=? where id=? and status=?";
	Object[] params={employeeId,time,"inprogress",ticketId,"open"};
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
		ticketDetail.setPriority(rs.getString("priority"));
		
		
		
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
		ticketDetail.setPriority(rs.getString("priority"));
		
		
		return ticketDetail;
		
	});
}
public EmployeeDetail checkadmin (int id)
{
	String sql="select id from seed_employee_details where id=? and role=(select id from seed_role where name=?)";
	Object[] params={id,"admin"};
	return jdbcTemplate.queryForObject(sql,params,(rs,rownum)->{
		EmployeeDetail employeeDetail=new EmployeeDetail();
		employeeDetail.setId(rs.getInt("id"));
		return employeeDetail;
	});
	
}
public EmployeeDetail checkEmployee(int id)
{
	String sql="select id from seed_employee_details where id=? and department=(select id from seed_department where name=?)";
	Object[] params={id,"admin"};
	return jdbcTemplate.queryForObject(sql,params,(rs,rownum)->{
		EmployeeDetail employeeDetail=new EmployeeDetail();
		employeeDetail.setId(rs.getInt("id"));
		return employeeDetail;
	});
	
}
public List<TicketDetail> ticketview(int id) {
	String sql="select *from ticket_details where user=?";
	Object[] params={id};
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
		 
		
		
		
		ticketDetail.setStatus(rs.getString("status"));
		ticketDetail.setPriority(rs.getString("priority"));
		
		
		return ticketDetail;
		
	});
}
}