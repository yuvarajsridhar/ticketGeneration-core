package com.yuvaraj.service;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.yuvaraj.dao.TicketDetailDao;
import com.yuvaraj.exception.ValidationException;
import com.yuvaraj.model.Department;
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
		ticketDetailDao.delete(ticketDetail.getId());
	}catch(ValidationException e){
		logger.log(Level.SEVERE,"exception occur",e);
	}
}
public void update(TicketDetail ticketDetail){
	try{
		ticketDetailValidator.updateValidation(ticketDetail);
		TicketDetailDao ticketDetailDao=new TicketDetailDao();
		ticketDetailDao.update(ticketDetail.getUserId().getId(), ticketDetail.getStatus());
	}catch(ValidationException e){
		logger.log(Level.SEVERE, "Exception occur", e);
		}
}
public void assignTicket(TicketDetail ticketDetail ){
	try{
		ticketDetailValidator.assignTicketValidation(ticketDetail);
		TicketDetailDao ticketDetailDao=new TicketDetailDao();
		ticketDetailDao.assignTicket(ticketDetail.getId(), ticketDetail.getAssignedTo().getId());
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
}
