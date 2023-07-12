package com.leedohwan.todolist;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.leedohwan.todolist.modelUsingJPA.ToDo;
import com.leedohwan.todolist.serviceUsingJPA.ToDoServiceUsingJPA;

@SpringBootTest
public class ToDoJpaTests2 {

	@Autowired
	private ToDoServiceUsingJPA toDoServiceUsingJPA;
	
//	@Test
	public void test1() {
		ToDo toDo = toDoServiceUsingJPA.findById(1);
		System.out.println(toDo);
	}
	
//	@Test
	public void test2() {
		toDoServiceUsingJPA.deleteById(9);
	}
	
//	@Test
	public void test3() {
		ToDo newToDo = new ToDo();
		newToDo.setId(0); // id 값 없거나 있어도 일치하지 않으면 시퀀스값 이용해서 insert 수행
		newToDo.setUsername("in28minutes");
		newToDo.setDescription("new Todo test");
		newToDo.setDone(false);
		ZoneId zone = ZoneId.of("GMT+09");
		newToDo.setTargetDate(ZonedDateTime.now(zone));
		toDoServiceUsingJPA.save(newToDo); // id 값 없거나 있어도 일치하지 않으면 시퀀스값 이용해서 insert 수행
	}
	
//	@Test
	public void test4() {
		ToDo toDo = toDoServiceUsingJPA.findById(2);
		System.out.println("1 >>> " + toDo);
		toDo.setDescription(toDo.getDescription() + "a");
		ToDo theToDo = toDoServiceUsingJPA.save(toDo);
		System.out.println("2 >>> " + theToDo);
	}
	
//	@Test
	public void test5() {
		System.out.println(toDoServiceUsingJPA.findByUsernameOrderByTargetDate("in28minutes"));
	}
	
	@Test
	public void test6() {
		System.out.println(toDoServiceUsingJPA.findByUsernameOrderByTargetDateDesc("in28minutes"));
	}
}
