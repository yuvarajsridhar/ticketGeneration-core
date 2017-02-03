package com.yuvaraj.validator;

import com.yuvaraj.exception.ValidationException;
import com.yuvaraj.model.Department;
import com.yuvaraj.util.ValidationUtil;

public class DepartmentValidation {
  public void validDepartment(Department department)throws ValidationException{
	  ValidationUtil.isInvalidObject(department, "empty object");
  }
  public void idValidation(Integer id)throws ValidationException{
	  ValidationUtil.isInvalidNumber(id, "invalid id");
  }
  public void namevalidation(String name)throws ValidationException{
	  ValidationUtil.isInvalidString(name, "invalid name");
  }public void statusValidation(boolean num)throws ValidationException{
	  ValidationUtil.isValidBoolean(num, "invalid status");
  }
  public void saveValidation(Department department)throws ValidationException{
	  validDepartment(department);
	  idValidation(department.getId());
	  namevalidation(department.getName());
	  statusValidation(department.isActive());
  }
  public void deleteValidation(Department department)throws ValidationException{
	  validDepartment(department);
	  idValidation(department.getId());
  }
}
