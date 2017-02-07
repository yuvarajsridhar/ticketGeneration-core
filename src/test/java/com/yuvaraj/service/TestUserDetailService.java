package com.yuvaraj.service;

import java.time.LocalDateTime;

import com.yuvaraj.dao.IssueDao;
import com.yuvaraj.dao.TicketDetailDao;
import com.yuvaraj.exception.ValidationException;
import com.yuvaraj.model.Department;
import com.yuvaraj.model.EmployeeDetail;
import com.yuvaraj.model.Issue;
import com.yuvaraj.model.TicketDetail;
import com.yuvaraj.model.UserDetail;


public class TestUserDetailService {

	public static void main(String[] args) throws ValidationException {
			UserDetailService userDetailService=new UserDetailService();

		testemployeeLogin();
	//	 testRegistration();
	//		testUpdate();
//	testCloseTicket();
			// testViewTicket();
		//	testAssignTicket();
			//testReplysolution();
            //  testReassign();
		//	testDeleteTicket();
	// ticketCreation();
			}
	
	static void testLogin() throws ValidationException {
		UserDetailService userDetailService=new UserDetailService();
		userDetailService.login("syu@gmail.com", "yuvaraj"); 
	}
	static void testemployeeLogin() throws ValidationException {
		EmployeeDetailService employeeDetailService=new EmployeeDetailService();
		employeeDetailService.login("s8@gmail.com", "ssss"); 
	}
	static void testRegistration() throws ValidationException{
		UserDetailService userDetailService=new UserDetailService();

		UserDetail userDetail=new UserDetail();
		userDetail.setId(2);
		userDetail.setEmailId("hdj@gmail.com");
		userDetail.setName("hjsh");
		userDetail.setPassword("jdjdnndd");
	userDetailService.regestration(userDetail);
		
	}
	static void ticketCreation(){
		TicketDetail ticketDetail=new TicketDetail();
		ticketDetail.setId(1);
		UserDetail userDetail=new UserDetail();
		userDetail.setId(1);
		ticketDetail.setUserId(userDetail);
		Department department=new Department();
		department.setId(1);
		ticketDetail.setDepartmentId(department);
		ticketDetail.setSubject("ndnjd");
		ticketDetail.setDescription("hjdhhjd");
		ticketDetail.setCreatedTime(LocalDateTime.now());
		ticketDetail.setPriority("high");
		TicketDetailService ticketDetailService=new TicketDetailService();
		ticketDetailService.createTicket(ticketDetail);
	}
	 static void  testUpdate(){
		 TicketDetailService ticketDetailService=new TicketDetailService();
		 TicketDetail ticketDetail=new TicketDetail();
		 ticketDetail.setId(1);
		 ticketDetail.setSubject("something");
         UserDetail userDetail=new UserDetail();
         userDetail.setId(1);
         ticketDetail.setUserId(userDetail);
		 ticketDetailService.update(ticketDetail);
	 }
	static void testCloseTicket(){
		TicketDetailService ticketDetailService=new TicketDetailService();
		TicketDetail ticketDetail=new TicketDetail();
		ticketDetail.setId(1);
		ticketDetailService.close(ticketDetail);
	}
	static void testViewTicket(){
		TicketDetailDao ticketDetailDao=new TicketDetailDao();
		System.out.println(ticketDetailDao.select(1));
	}
	static void testAssignTicket(){
		TicketDetailService ticketDetailService=new TicketDetailService();
		TicketDetail ticketDetail=new TicketDetail();
		ticketDetail.setId(1);
		EmployeeDetail employeeDetail =new EmployeeDetail();
		employeeDetail.setId(1);
		ticketDetail.setModifiedTime(LocalDateTime.now());
		ticketDetail.setAssignedTo(employeeDetail);
		
		ticketDetailService.assignTicket(ticketDetail);
	}
	static void testReplysolution(){
	IssueService issueService=new IssueService();
	Issue issue=new Issue();
	issue.setId(1);
	TicketDetail ticketDetail=new TicketDetail();
	ticketDetail.setId(1);
	issue.setTicket(ticketDetail);
	issue.setSolution("can be solved");
	issueService.replyToTicket(issue);
	}
	static void testReassign(){
		TicketDetailService ticketDetailService=new TicketDetailService();
		TicketDetail ticketDetail=new TicketDetail();
		ticketDetail.setId(1);
		EmployeeDetail employeeDetail =new EmployeeDetail();
		employeeDetail.setId(1);
		ticketDetail.setModifiedTime(LocalDateTime.now());
		ticketDetail.setAssignedTo(employeeDetail);
		
		ticketDetailService.updateReassign(ticketDetail);
	}
	static void testDeleteTicket(){
		TicketDetailService ticketDetailService=new TicketDetailService();
		TicketDetail ticketDetail=new TicketDetail();
		ticketDetail.setId(1);
		UserDetail userDetail=new UserDetail();
		userDetail.setId(1);
		ticketDetail.setUserId(userDetail);

		ticketDetailService.delete(ticketDetail);
	}
}
