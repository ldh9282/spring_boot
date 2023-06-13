package com.leedohwan.todolist.model;

import java.time.ZonedDateTime;

import lombok.Data;

@Data
public class ToDo {
	private int todo_id;
	private String username;
	private String description;
	private boolean done;
	private ZonedDateTime target_date;
	
}
