package com.leedohwan.todolist.service;

import java.util.List;

import com.leedohwan.todolist.model.ToDo;

public interface ToDoService {

	List<ToDo> retrieveToDoListByUsername(String username);

	ToDo retrieveToDoByUsernameAndId(String username, int todo_id);

	void deleteToDoByUsernameAndId(String username, int todo_id);
}
