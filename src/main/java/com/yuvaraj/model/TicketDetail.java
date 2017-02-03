package com.yuvaraj.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TicketDetail {
private int id;
private UserDetail userId;
private Department departmentId;
private String subject;
private String Description;
private EmployeeDetail assignedTo;
private LocalDateTime createdTime;
private String status;
private LocalDateTime modifiedTime;
}
