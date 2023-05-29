package com.leedohwan.todolist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.leedohwan.todolist.mapper.ToDoMapper;

@SpringBootTest
public class ToDoTests {

	@Autowired
	private ToDoMapper toDoService;
	
	
	@Test
	public void list() {
		System.out.println(toDoService.retrieveToDoListByUsername("in28minutes"));
	}
}
