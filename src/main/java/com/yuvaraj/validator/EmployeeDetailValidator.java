package com.yuvaraj.validator;

import com.yuvaraj.exception.ValidationException;
import com.yuvaraj.model.EmployeeDetail;
import com.yuvaraj.util.ValidationUtil;

public class EmployeeDetailValidator {
public void employeeValidation(EmployeeDetail employeeDetail)throws ValidationException{
	ValidationUtil.isInvalidObject(employeeDetail, "empty object");
	}
public void idValidation(Integer id)throws ValidationException{
	ValidationUtil.isInvalidNumber(id, "invalid id");
}
public void nameValidation(String name)throws ValidationException{
	ValidationUtil.isInvalidString(name, "invalid name");
}
public void emailValidation(String email)throws ValidationException{
	ValidationUtil.isValidEmail(email, "invalid email");
}
public void passwordValidation(String password)throws ValidationException{
	ValidationUtil.isValidPassword(password, "invalid password");
}
public void departmentValidation(Integer id)throws ValidationException{
	ValidationUtil.isInvalidNumber(id, "invalid department id");
}
public  void statusValidation(boolean num)throws ValidationException{
	ValidationUtil.isValidBoolean(num, "invalid status");
}
public void roleValidation(String name)throws ValidationException{
	ValidationUtil.isInvalidString(name, "invalid role");
}
public void saveValidation(EmployeeDetail employeeDetail )throws  ValidationException{
	employeeValidation(employeeDetail);
	idValidation(employeeDetail.getId());
	nameValidation(employeeDetail.getName());
	emailValidation(employeeDetail.getEmailId());
	passwordValidation(employeeDetail.getPassword());
	departmentValidation(employeeDetail.getDepartment().getId());
	statusValidation(employeeDetail.isActive());
	roleValidation(employeeDetail.getRole());
}
public void deleteValidation(EmployeeDetail employeeDetail)throws ValidationException{
	employeeValidation(employeeDetail);
	idValidation(employeeDetail.getId());
}
public void updateValidation(EmployeeDetail employeeDetail)throws ValidationException{
 employeeValidation(employeeDetail);
 idValidation(employeeDetail.getId());
}
}
