package com.yuvaraj.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.yuvaraj.model.Issue;
import com.yuvaraj.model.TicketDetail;
import com.yuvaraj.util.ConnectionUtil;

public class IssueDao {
JdbcTemplate jdbcTemplate=ConnectionUtil.getJdbcTemplate();
public int save(Issue issue)

{
	String sql="insert into issue(id,ticket,solution)values (?,?,?)";
	Object[] params={issue.getId(),issue.getTicket().getId(),issue.getSolution()};
	return (jdbcTemplate.update(sql,params));
	}
public int delete(int id) {
	String sql = "delete from issues where id =?";
	Object[] params = { id };
	return (jdbcTemplate.update(sql, params));
}
public int update(int id,String solution){
	String sql="update issues set solution=? where id=?";
	Object[] params={solution,id};
	return jdbcTemplate.update(sql,params);
}
public List<Issue> select() {
	String sql="select *from issues ";
	return jdbcTemplate.query(sql,(rs,rownum)->{
		final  Issue issue= new Issue();
	  issue.setId(rs.getInt("id"));
	  TicketDetail ticketDetail=new TicketDetail();
	  ticketDetail.setId(rs.getInt("ticket"));
	  issue.setTicket(ticketDetail);
		return issue;
		
	});
}
public Issue select(int id) {
	String sql="select *from issues where id=?";
	Object[] params={id};
	return jdbcTemplate.queryForObject(sql,params,(rs,rownum)->{
		final  Issue issue= new Issue();
	  issue.setId(rs.getInt("id"));
	  TicketDetail ticketDetail=new TicketDetail();
	  ticketDetail.setId(rs.getInt("ticket"));
	  issue.setTicket(ticketDetail);
		return issue;
		
		
	});
}
public List<TicketDetail> viewTicket(int id){
	String sql="select id,subject,description from ticket_details where assigned_to=?";
	Object[] params={id};
	return jdbcTemplate.query(sql,params,(rs,rownum)->{
	final	TicketDetail ticketDetail=new TicketDetail();
	ticketDetail.setId(rs.getInt("id"));
	ticketDetail.setSubject(rs.getString("status"));
	ticketDetail.setDescription(rs.getString("description"));
	
		return ticketDetail;
	});
}
public int updateStatus(int ticketId){
	String sql="update ticket_details set status=? where id=?";
	Object[] params={"resolved",ticketId};
	return jdbcTemplate.update(sql,params);
}
}
