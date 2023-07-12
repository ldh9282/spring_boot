package com.leedohwan.todolist;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.leedohwan.todolist.modelUsingJPA.ToDo;
import com.leedohwan.todolist.repositoryUsingJPA.ToDoRepository;

/***
 * 
 * @설명 JPA Repository Test
 * <p>기능: 간단한 crud, order by 목록조회</p>
 * <p>목적: 네이티브 쿼리 없이 DAO 역할</p>
 */
@SpringBootTest
public class ToDoJpaTests {

	@Autowired
	private ToDoRepository toDoRepository;
	
//	@Test
	public void test1() {
		System.out.println(toDoRepository.findByUsernameOrderByTargetDate("in28minutes"));
	}
	
//	@Test
	public void test2() {
		System.out.println(toDoRepository.findById(1));
	}
	
//	@Test
	public void test3() {
		toDoRepository.deleteById(3);
	}
	
//	@Test
	public void test4() {
		ToDo toDo = toDoRepository.findById(2);
		System.out.println("1 >>> " + toDo);
		toDo.setDescription(toDo.getDescription() + "a");
		ToDo theToDo = toDoRepository.save(toDo);
		System.out.println("2 >>> " + theToDo);
	}
	
	@Test
	public void test5() {
		ToDo newToDo = new ToDo();
		newToDo.setId(0); // id 값 없거나 있어도 일치하지 않으면 시퀀스값 이용해서 insert 수행
		newToDo.setUsername("in28minutes");
		newToDo.setDescription("new Todo test");
		newToDo.setDone(false);
		ZoneId zone = ZoneId.of("GMT+09");
		newToDo.setTargetDate(ZonedDateTime.now(zone));
		System.out.println("2 >>> " + newToDo);
		ToDo theNewTodo = toDoRepository.save(newToDo); // id 값 없거나 있어도 일치하지 않으면 시퀀스값 이용해서 insert 수행
		System.out.println("1 >>> " + theNewTodo);
	}
}
