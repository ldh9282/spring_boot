package com.leedohwan.todolist.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class ToDo {
	private int todo_id;
	private String username;
	private String description;
	private boolean done;
	private LocalDateTime targetDate;
}