package com.leedohwan.todolist.resourceUsingJpa;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.leedohwan.todolist.modelUsingJPA.ToDo;
import com.leedohwan.todolist.repositoryUsingJPA.ToDoRepository;

//@RestController
public class ToDoResourceJPA {
	
	@Autowired
	private ToDoRepository toDoRepository;
	
	@GetMapping("/users/{username}/todos")
	public List<ToDo> retrieveToDoListByUsername(@PathVariable String username) {
		return toDoRepository.findByUsernameOrderByTargetDate(username);
	}
	
	@GetMapping("users/{username}/todos/{todo_id}")
	public ToDo retrieveToDoByUsernameAndId(@PathVariable String username, @PathVariable int todo_id) {
		return toDoRepository.findById(todo_id);
	}
	
	@DeleteMapping("users/{username}/todos/{todo_id}")
	public void deleteToDoByUsernameAndId(@PathVariable String username, @PathVariable int todo_id) {
	}
	
	@PutMapping("users/{username}/todos/{todo_id}")
	public ToDo updateToDoByUsernameAndId(@PathVariable String username, @PathVariable int todo_id,
											@RequestBody ToDo toDo) {
		return null;
	}
	
	@PostMapping("users/{username}/todos/new")
	public ToDo insertToDoByUsernameAndId(@PathVariable String username,
											@RequestBody ToDo toDo) {
		
		return null;
	}
}
