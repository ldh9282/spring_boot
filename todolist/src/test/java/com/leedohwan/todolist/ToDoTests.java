package com.leedohwan.todolist;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.leedohwan.todolist.mapper.ToDoMapper;
import com.leedohwan.todolist.model.ToDo;

@SpringBootTest
public class ToDoTests {

	@Autowired
	private ToDoMapper toDoService;
	
	
//	@Test
	public void list() {
		System.out.println(toDoService.retrieveToDoListByUsername("in28minutes"));
	}
	
//	@Test
	public void selectOne() {
		System.out.println(toDoService.retrieveToDoById(1));
	}
	
	@Test
	public void update() {
		ToDo todo = toDoService.retrieveToDoById(3);
		todo.setDescription("Eating(Changed)");
		todo.setDone(true);
		ZoneId zone = ZoneId.of("GMT+09");
		todo.setTarget_date(ZonedDateTime.now(zone));
		
		toDoService.updateToDo(todo);
		
		System.out.println(toDoService.retrieveToDoById(todo.getTodo_id()));
	}
	
//	@Test
	public void delete() {
		toDoService.deleteToDoById(1);
		
		ToDo toDo = toDoService.retrieveToDoById(1);
		
		if (toDo == null) {
			System.out.println("삭제됨...");
		} else {
			System.out.println(toDo);
		}
	}
	
	@Test
	public void insert() {
		ToDo toDo = new ToDo();
		toDo.setUsername("in28minutes");
		toDo.setDescription("Eating(insert test)");
		toDo.setDone(false);
		ZoneId zone = ZoneId.of("GMT+09");
		toDo.setTarget_date(ZonedDateTime.now(zone));
		
		toDoService.insertToDo(toDo);
		
		System.out.println("시퀀스 id: " + toDo.getTodo_id() + " >>> " + toDoService.retrieveToDoById(toDo.getTodo_id()));
	}
	
//	@Test
	public void zonedatetime() {
		ZoneId zone = ZoneId.of("GMT+09");
		System.out.println(ZonedDateTime.now(zone));
	}
	
}
