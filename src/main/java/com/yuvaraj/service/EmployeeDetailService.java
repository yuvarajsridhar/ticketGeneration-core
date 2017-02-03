package com.yuvaraj.service;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.yuvaraj.dao.EmployeeDetailDao;
import com.yuvaraj.exception.ValidationException;
import com.yuvaraj.model.Department;
import com.yuvaraj.model.EmployeeDetail;
import com.yuvaraj.validator.EmployeeDetailValidator;

public class EmployeeDetailService {
 EmployeeDetailValidator employeeDetailValidator=new EmployeeDetailValidator();
	final Logger logger = Logger.getLogger(Department.class.getName());

 public void save(EmployeeDetail employeeDetail){
	 try{
		 employeeDetailValidator.saveValidation(employeeDetail);
		 EmployeeDetailDao employeeDetailDao=new EmployeeDetailDao();
		 employeeDetailDao.save(employeeDetail);
	 }catch(ValidationException e){
		 logger.log(Level.SEVERE, "exception occur",e);
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
}
