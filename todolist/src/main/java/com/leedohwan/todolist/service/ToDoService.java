package com.leedohwan.todolist.service;

import java.util.List;

import com.leedohwan.todolist.model.ToDo;

public interface ToDoService {

	List<ToDo> retrieveToDoListByUsername(String username);
	
	ToDo retrieveToDoById(int todo_id);

	void deleteToDoById(int todo_id);

	void updateToDo(ToDo toDo);

	void insertToDo(ToDo toDo);

}
