package com.yuvaraj.validator;

import com.yuvaraj.exception.ValidationException;
import com.yuvaraj.model.UserDetail;
import com.yuvaraj.util.ValidationUtil;

public class UserDetailValidator {
 public void userDetailValidation(UserDetail userDetail)throws ValidationException{
	 ValidationUtil.isInvalidObject(userDetail, "empty object");
 }
 public void idValidation(Integer id) throws ValidationException{
	 ValidationUtil.isInvalidNumber(id, "invalid id");
 }
 public void nameValidation(String name)throws ValidationException{
	 ValidationUtil.isInvalidString(name, "invalid name");
 }
 public void emailValidation(String email)throws ValidationException{
	 ValidationUtil.isValidEmail(email, "invalid email");
 }
 public void passwordValidation(String pass)throws ValidationException{
	 ValidationUtil.isValidPassword(pass, "invalid password");
 }
 public void statusValidation(boolean id)throws ValidationException{
	 ValidationUtil.isValidBoolean(id, "invalid status");
 }
 public void saveValidation(UserDetail userDetail)throws ValidationException{
	 userDetailValidation(userDetail);
	 idValidation(userDetail.getId());
	 nameValidation(userDetail.getName());
	 emailValidation(userDetail.getEmailId());
	 passwordValidation(userDetail.getPassword());
	 statusValidation(userDetail.isActive());
	 }
 public void deleteValidation(UserDetail userDetail)throws ValidationException{
	 userDetailValidation(userDetail);
	 idValidation(userDetail.getId());
 }
 public void updateValidation(UserDetail userDetail)throws ValidationException{
	 userDetailValidation(userDetail);
	 idValidation(userDetail.getId());
	 passwordValidation(userDetail.getPassword());
 }
 public void loginValidation(String Temail,String Tpassword,String email,String password)throws ValidationException{
	 String str1=Temail;
	 String str2=Tpassword;
	 if( str1.equals(email) && str2.equals(password)){
		 
		 
	 }else 
	 {
		 throw new ValidationException("login fail");
	 }
	
 }
}
