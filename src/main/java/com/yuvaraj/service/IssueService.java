package com.yuvaraj.service;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.yuvaraj.dao.IssueDao;
import com.yuvaraj.exception.ValidationException;
import com.yuvaraj.model.Issue;
import com.yuvaraj.validator.IssueValidator;

public class IssueService {
IssueValidator issueValidator=new IssueValidator();
final Logger logger = Logger.getLogger(Issue.class.getName());

public void replyToTicket(Issue issue){
	try{
		issueValidator.saveValidation(issue);
		IssueDao issueDao=new IssueDao();
		issueDao.save(issue);
		issueDao.updateStatus(issue.getTicket().getId());
	}
	catch(ValidationException e){
		logger.log(Level.SEVERE, "Exception occur", e);
	}
}

}
