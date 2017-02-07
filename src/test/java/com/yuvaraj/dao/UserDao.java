package com.yuvaraj.dao;

import com.yuvaraj.model.EmployeeDetail;
import com.yuvaraj.model.UserDetail;

public class UserDao {

	public static void main(String[] args) {
	/*	UserDetail userDetail=new UserDetail();
		userDetail.setId(5);
		userDetail.setName("babu");
		userDetail.setEmailId("babu@gmail.com");
		userDetail.setPassword("babu");
UserDetailDao userDetailDao=new UserDetailDao();
userDetailDao.save(userDetail);*/
		EmployeeDetail employeeDetail=new EmployeeDetail();
		employeeDetail.setEmailId("s8@gmail.com");
		employeeDetail.setPassword("sssss");
		EmployeeDetailDao employeeDetailDao=new EmployeeDetailDao();
		employeeDetailDao.selectOne(employeeDetail.getEmailId());
	}

}
