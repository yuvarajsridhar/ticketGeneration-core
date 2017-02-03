package com.yuvaraj.validator;

import java.time.LocalDateTime;

import com.yuvaraj.exception.ValidationException;
import com.yuvaraj.model.TicketDetail;
import com.yuvaraj.util.ValidationUtil;

public class TicketDetailValidator {
public void ticketValidation(TicketDetail ticketDetail)throws ValidationException{
	ValidationUtil.isInvalidObject(ticketDetail, "object is empty");
}
public void idvalidation(Integer id)throws ValidationException{
	ValidationUtil.isInvalidNumber(id, "invalid id");
}
public void userValidation(Integer id)throws ValidationException{
	ValidationUtil.isInvalidNumber(id, "invalid user id");
}
public void departmentValidation(Integer id)throws ValidationException{
	ValidationUtil.isInvalidNumber(id, "invalid department");
}
public void subjectValidation(String name)throws ValidationException{
	ValidationUtil.isInvalidString(name, "invalid subject");
}
public void descriptionValidation(String name)throws ValidationException{
	ValidationUtil.isInvalidString(name, "invalid description");
}
public void employeeValidation(Integer id)throws ValidationException{
	ValidationUtil.isInvalidNumber(id, "invalid employee");
}
public void timeValidation(LocalDateTime num)throws ValidationException{
	ValidationUtil.isValidDateTime(num, "invalid timestramp");
}
public void statusValidation(String name)throws ValidationException{
	ValidationUtil.isInvalidString(name, "invalid status");
}
public void saveValidation(TicketDetail ticketDetail)throws ValidationException{
	ticketValidation(ticketDetail);
	idvalidation(ticketDetail.getId());
	userValidation(ticketDetail.getUserId().getId());
	departmentValidation(ticketDetail.getDepartmentId().getId());
	subjectValidation(ticketDetail.getSubject());
   descriptionValidation(ticketDetail.getDescription());
   employeeValidation(ticketDetail.getAssignedTo().getId());
   timeValidation(ticketDetail.getCreatedTime());
   timeValidation(ticketDetail.getModifiedTime());
   statusValidation(ticketDetail.getStatus());
}
public void deleteValidation(TicketDetail ticketDetail)throws ValidationException{
	idvalidation(ticketDetail.getId());
}
public void updateValidation(TicketDetail ticketDetail)throws ValidationException{
	idvalidation(ticketDetail.getId());
	statusValidation(ticketDetail.getStatus());
}
public void assignTicketValidation(TicketDetail ticketDetail)throws ValidationException{
	idvalidation(ticketDetail.getId());
	employeeValidation(ticketDetail.getId());
}
}
