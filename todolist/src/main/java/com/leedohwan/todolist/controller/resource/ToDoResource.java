package com.leedohwan.todolist.controller.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.leedohwan.todolist.model.ToDo;
import com.leedohwan.todolist.service.ToDoService;

@RestController
public class ToDoResource {
	
	@Autowired
	private ToDoService toDoService;
	
	@GetMapping("/users/{username}/todos")
	public List<ToDo> retrieveToDoListByUsername(@PathVariable String username) {
		return toDoService.retrieveToDoListByUsername(username);
	}
	
	@GetMapping("users/{username}/todos/{todo_id}")
	public ToDo retrieveToDoByUsernameAndId(@PathVariable String username, @PathVariable int todo_id) {
		return toDoService.retrieveToDoByUsernameAndId(username, todo_id);
	}
	
	@DeleteMapping("users/{username}/todos/{todo_id}")
	public void deleteToDoByUsernameAndId(@PathVariable String username, @PathVariable int todo_id) {
		toDoService.deleteToDoByUsernameAndId(username, todo_id);
	}
	
	@PutMapping("users/{username}/todos/{todo_id}")
	public ToDo updateToDoByUsernameAndId(@PathVariable String username, @PathVariable int todo_id,
											@RequestBody ToDo toDo) {
		ToDo theToDo = toDoService.updateToDoByUsernameAndId(username, todo_id, toDo);
		return theToDo;
	}
	
	@PostMapping("users/{username}/todos")
	public ToDo insertToDoByUsernameAndId(@PathVariable String username,
											@RequestBody ToDo toDo) {
		ToDo theToDo = toDoService.insertToDoByUsername(username, toDo);
		return theToDo;
	}
}
