package com.yuvaraj.service;

import java.util.logging.Level;

import java.util.logging.Logger;


import com.yuvaraj.dao.UserDetailDao;
import com.yuvaraj.exception.ValidationException;
import com.yuvaraj.model.Department;
import com.yuvaraj.model.UserDetail;
import com.yuvaraj.validator.UserDetailValidator;

public class UserDetailService {
	final Logger logger = Logger.getLogger(Department.class.getName());
	UserDetailValidator userDetailValidator=new UserDetailValidator();

public void regestration(UserDetail userDetail){
	try{
		userDetailValidator.saveValidation(userDetail);
		UserDetailDao userDetailDao=new UserDetailDao();
		userDetailDao.save(userDetail);
	}catch (ValidationException e){
		logger.log(Level.SEVERE, "exception occur %s",e);
	}
}
public void delete(UserDetail userDetail){
	try{
		userDetailValidator.deleteValidation(userDetail);
		UserDetailDao userDetailDao=new UserDetailDao();
		userDetailDao.delete(userDetail.getId());
	}catch(ValidationException e){
		logger.log(Level.SEVERE, "exception occur", e);
	}
}
public void update(UserDetail userDetail){
	try{
		userDetailValidator.updateValidation(userDetail);
		UserDetailDao userDetailDao=new UserDetailDao();
		userDetailDao.update(userDetail.getId(), userDetail.getPassword());
	}catch(ValidationException e){
		logger.log(Level.SEVERE,"exception occur", e);
	}
}
public void login(String email,String password){
	try{
		UserDetailDao userDetailDao=new UserDetailDao();
		UserDetail row=(userDetailDao.selectOne(email));
		String tname=row.getEmailId();
		String tpassword=row.getName();
		
		String message=(userDetailValidator.loginValidation(tname, tpassword, email, password));
		
		System.out.println(message);
	}
	catch(ValidationException e){
		logger.log(Level.SEVERE, "exception occur", e);
	}
}
}
