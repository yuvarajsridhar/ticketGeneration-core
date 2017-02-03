package com.yuvaraj.model;

import lombok.Data;

@Data
public class Issue {
private int id;
private TicketDetail ticket;
private String solution;
}
