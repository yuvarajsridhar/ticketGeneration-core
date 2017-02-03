package com.yuvaraj.validator;

import com.yuvaraj.exception.ValidationException;
import com.yuvaraj.model.Issue;
import com.yuvaraj.util.ValidationUtil;

public class IssueValidator {
public void issuevalidation(Issue issue)throws ValidationException{
	ValidationUtil.isInvalidObject(issue, "invalid object");
}
public void idValidation(int id)throws ValidationException{
	ValidationUtil.isInvalidNumber(id, "invalid id");
	
}
public void ticketValidation(int id)throws ValidationException{
	ValidationUtil.isInvalidNumber(id, "invalid ticket");
	
}
public void solutionValidation(String msg)throws ValidationException{
	ValidationUtil.isInvalidString(msg, "invalid solution");
}
public void saveValidation(Issue issue)throws ValidationException{
	idValidation(issue.getId());
	ticketValidation(issue.getTicket().getId());
	solutionValidation(issue.getSolution());
}
public void deleteValidation(Issue issue)throws ValidationException{
	idValidation(issue.getId());
}
public void updateValidation(Issue issue )throws ValidationException{
	idValidation(issue.getId());
	solutionValidation(issue.getSolution());
}
}
