package com.yuvaraj.service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.yuvaraj.dao.IssueDao;
import com.yuvaraj.dao.TicketDetailDao;
import com.yuvaraj.exception.ValidationException;
import com.yuvaraj.model.Department;
import com.yuvaraj.model.EmployeeDetail;
import com.yuvaraj.model.TicketDetail;
import com.yuvaraj.validator.TicketDetailValidator;

public class TicketDetailService {
 TicketDetailValidator ticketDetailValidator=new TicketDetailValidator();
	final Logger logger = Logger.getLogger(Department.class.getName());
public void save(TicketDetail ticketDetail){
	try{
		ticketDetailValidator.saveValidation(ticketDetail);
		TicketDetailDao ticketDetailDao=new TicketDetailDao();
		ticketDetailDao.save(ticketDetail);
	}catch(ValidationException e){
		logger.log(Level.SEVERE,"exception occur",e);
	}
}
public void delete(TicketDetail ticketDetail){
	try{
		ticketDetailValidator.deleteValidation(ticketDetail);
		TicketDetailDao ticketDetailDao=new TicketDetailDao();
		EmployeeDetail row =ticketDetailDao.checkadmin(ticketDetail.getUserId().getId());
	     ticketDetailValidator.deleteTicketAssign(row);
			IssueDao issueDao=new IssueDao();
			issueDao.deleteIssue(ticketDetail);
		ticketDetailDao.delete(ticketDetail.getId(),ticketDetail.getUserId().getId());
	}catch(ValidationException e){
		logger.log(Level.SEVERE,"exception occur",e);
	}
}
public void update(TicketDetail ticketDetail) throws ValidationException{
	try{
		ticketDetailValidator.updateValidation(ticketDetail);
		TicketDetailDao ticketDetailDao=new TicketDetailDao();
		ticketDetailDao.update(ticketDetail.getId(),ticketDetail.getSubject());
	}catch(ValidationException e){
		logger.log(Level.SEVERE, "Exception occur", e);
		throw e;
		}
}
public void createTicket(TicketDetail ticketDetail) throws ValidationException{
	try{
		ticketDetailValidator.createTicketValidation(ticketDetail);
		TicketDetailDao ticketDetailDao=new TicketDetailDao();
		ticketDetailDao.createticket(ticketDetail);
		
	}catch(ValidationException e){
		logger.log(Level.SEVERE,"Exception occur", e);
		throw e;
	}
}
public void assignTicket(TicketDetail ticketDetail ){
	try{
		ticketDetailValidator.assignTicketValidation(ticketDetail);
		TicketDetailDao ticketDetailDao=new TicketDetailDao();
		Department department=new Department();
		EmployeeDetail row=ticketDetailDao.checkEmployee(ticketDetail.getUserId().getId(),department.getName());
		ticketDetailValidator.employeeValidation(row);
		ticketDetailDao.assignTicket(ticketDetail.getId(), ticketDetail.getAssignedTo().getId(),ticketDetail.getModifiedTime());
	}catch(ValidationException e)
	{
		logger.log(Level.SEVERE,"Exception occur", e);
	}
}
public void updateReassign(TicketDetail ticketDetail){
	try{
		ticketDetailValidator.assignTicketValidation(ticketDetail);
		TicketDetailDao ticketDetailDao=new TicketDetailDao();
		ticketDetailDao.reassignTicket(ticketDetail.getId(), ticketDetail.getAssignedTo().getId());
	}catch(ValidationException e){
		logger.log(Level.SEVERE, "Exception occur", e);
		}
}
public void close(TicketDetail ticketDetail) throws ValidationException{
	try{
		ticketDetailValidator.closeticketValidation(ticketDetail);
		TicketDetailDao ticketDetailDao=new TicketDetailDao();
		ticketDetailDao.closeTicket(ticketDetail.getId());
	}catch(ValidationException e){
		logger.log(Level.SEVERE, "exception occur", e);
		throw e;
	}
}
public List<TicketDetail> viewticket(TicketDetail ticketDetail) throws ValidationException{
	TicketDetailDao ticketDetailDao=new TicketDetailDao();
	return ticketDetailDao.ticketview(ticketDetail.getUserId().getId());
}
}