package com.yuvaraj.service;

import com.yuvaraj.dao.DepartmentDao;
import com.yuvaraj.exception.ValidationException;
import com.yuvaraj.model.Department;
import com.yuvaraj.validator.DepartmentValidation;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DepartmentService {
public void save(Department department){
	DepartmentValidation departmentValidation=new DepartmentValidation();
	final Logger logger = Logger.getLogger(Department.class.getName());
	try{
		departmentValidation.saveValidation(department);
		DepartmentDao  departmentDao=new DepartmentDao();
		departmentDao.save(department);
	}catch (ValidationException e){
		logger.log(Level.SEVERE, "exception occur %s", e);
	}
}
public void delete(Department department){
	DepartmentValidation departmentValidation=new DepartmentValidation();
	final Logger logger = Logger.getLogger(Department.class.getName());
	try{
		departmentValidation.deleteValidation(department);
		DepartmentDao  departmentDao=new DepartmentDao();
		departmentDao.delete(department.getId());
	}catch (ValidationException e){
		logger.log(Level.SEVERE, "exception occur %s", e);
	}
}
}
