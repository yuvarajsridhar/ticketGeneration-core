package com.yuvaraj.model;

import lombok.Data;

@Data
public class UserDetail {
private int id;
private String name;
private String emailId;
private String password;
private boolean active;
}
