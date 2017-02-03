package com.yuvaraj.service;

import java.time.LocalDateTime;

import com.yuvaraj.dao.TicketDetailDao;
import com.yuvaraj.model.EmployeeDetail;
import com.yuvaraj.model.Issue;
import com.yuvaraj.model.TicketDetail;
import com.yuvaraj.model.UserDetail;


public class TestUserDetailService {

	public static void main(String[] args) {
			UserDetailService userDetailService=new UserDetailService();

		//testLogin();
	//	 testRegistration();
	//		testUpdate();
//	testCloseTicket();
			// testViewTicket();
			//testAssignTicket();
			testReplysolution();
            //  testReassign();
			
			}
	
	static void testLogin(){
		UserDetailService userDetailService=new UserDetailService();
		userDetailService.login("syu@gmail.com", "yuvardn"); 
	}
	static void testRegistration(){
		UserDetailService userDetailService=new UserDetailService();

		UserDetail userDetail=new UserDetail();
		userDetail.setId(2);
		userDetail.setEmailId("hdj@gmail.com");
		userDetail.setName("hjsh");
		userDetail.setPassword("jdjdnndd");
	userDetailService.regestration(userDetail);
		
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
}
