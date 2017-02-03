package com.yuvaraj.model;

import lombok.Data;

@Data
public class EmployeeDetail {
private int id;
private String name;
private String emailId;
private String Password;
private Department department;
private boolean active;
private Role role;
}
