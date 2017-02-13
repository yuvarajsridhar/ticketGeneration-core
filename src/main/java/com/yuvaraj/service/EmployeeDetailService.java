package com.yuvaraj.service;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.yuvaraj.dao.EmployeeDetailDao;
import com.yuvaraj.dao.UserDetailDao;
import com.yuvaraj.exception.ValidationException;
import com.yuvaraj.model.Department;
import com.yuvaraj.model.EmployeeDetail;
import com.yuvaraj.model.UserDetail;
import com.yuvaraj.validator.EmployeeDetailValidator;
import com.yuvaraj.validator.UserDetailValidator;

public class EmployeeDetailService {
 EmployeeDetailValidator employeeDetailValidator=new EmployeeDetailValidator();
	final Logger logger = Logger.getLogger(Department.class.getName());

 public void save(EmployeeDetail employeeDetail) throws ValidationException{
	 try{
		 employeeDetailValidator.saveValidation(employeeDetail);
		 EmployeeDetailDao employeeDetailDao=new EmployeeDetailDao();
		 employeeDetailDao.save(employeeDetail);
	 }catch(ValidationException e){
		 logger.log(Level.SEVERE, "exception occur",e);
		 throw e;
	 }
 }
 public void delete(EmployeeDetail employeeDetail){
	 try{
		 employeeDetailValidator.deleteValidation(employeeDetail);
		 EmployeeDetailDao employeeDetailDao=new EmployeeDetailDao();
		 employeeDetailDao.delete(employeeDetail.getId());
	 }catch (ValidationException e){
		 logger.log(Level.CONFIG,"exception occur",e);
	 }
 }
 public EmployeeDetail  login(String email,String password) throws ValidationException{
		
		try{
			System.out.println("hello");
			UserDetailValidator userDetailValidator=new UserDetailValidator();
			System.out.println("hello1");

		 EmployeeDetailDao dao=new EmployeeDetailDao();
			System.out.println("hello2");

		 System.out.println(dao.selectOne(email).getEmailId());
		EmployeeDetail row	= dao.selectOne(email);
		System.out.println("hello");

		System.out.println(row.getEmailId());
		String name=row.getName();
			String tname=row.getEmailId();
			String tpassword=row.getPassword();
			System.out.println(row.getEmailId());
			userDetailValidator.loginValidation(tname, tpassword, email, password);
			return row;
			
		}
		catch(ValidationException e){
			logger.log(Level.SEVERE, "exception occur", e);
		     throw e;
		
		}
		
	    
	    
	}
}
