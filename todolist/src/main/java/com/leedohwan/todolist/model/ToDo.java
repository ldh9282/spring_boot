package com.leedohwan.todolist.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class ToDo {
	private int todo_id;
	private String username;
	private String description;
	private boolean done;
	private LocalDateTime target_date;
}
