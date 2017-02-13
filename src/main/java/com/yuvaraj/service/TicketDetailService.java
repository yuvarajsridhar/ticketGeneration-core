package com.yuvaraj.service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.mail.EmailException;

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
	}catch(ValidationException  e){
		logger.log(Level.SEVERE,"exception occur",e);
	}
}
public void delete(TicketDetail ticketDetail) throws ValidationException{
	try{
		System.out.println("0");
		ticketDetailValidator.deleteValidation(ticketDetail);
		TicketDetailDao ticketDetailDao=new TicketDetailDao();
		System.out.println("1");
		EmployeeDetail row =ticketDetailDao.checkadmin(ticketDetail.getAssignedTo().getId());
		System.out.println("2");
	     ticketDetailValidator.deleteTicketAssign(row);
	     System.out.println("3");
			IssueDao issueDao=new IssueDao();
			System.out.println("4");
			issueDao.deleteIssue(ticketDetail);
		ticketDetailDao.delete(ticketDetail.getId(),ticketDetail.getAssignedTo().getId());
	}catch(ValidationException e){
		logger.log(Level.SEVERE,"exception occur",e);
		throw e;
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
public void createTicket(TicketDetail ticketDetail) throws ValidationException,EmailException{
	try{
		ticketDetailValidator.createTicketValidation(ticketDetail);
		TicketDetailDao ticketDetailDao=new TicketDetailDao();
		ticketDetailDao.createticket(ticketDetail);
		
	}catch(ValidationException | EmailException e){
		logger.log(Level.SEVERE,"Exception occur", e);
		throw e;
	}
}
public void assignTicket(TicketDetail ticketDetail ) throws ValidationException{
	try{
		System.out.println("1");
		ticketDetailValidator.assignTicketValidation(ticketDetail);
		System.out.println("2");
		TicketDetailDao ticketDetailDao=new TicketDetailDao();
		System.out.println("3");
		Department department=new Department();
		System.out.println("4");
		EmployeeDetail row=ticketDetailDao.checkEmployee(ticketDetail.getAssignedTo().getId());
		System.out.println("5");
		ticketDetailValidator.employeeValidation(row);
		System.out.println("6");
		ticketDetailDao.assignTicket(ticketDetail.getId(), ticketDetail.getAssignedTo().getId(),ticketDetail.getModifiedTime());
		System.out.println("7");
	}catch(ValidationException e)
	{
		logger.log(Level.SEVERE,"Exception occur", e);
		throw e;
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