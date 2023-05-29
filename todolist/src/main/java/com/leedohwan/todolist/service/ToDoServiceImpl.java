package com.leedohwan.todolist.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leedohwan.todolist.mapper.ToDoMapper;
import com.leedohwan.todolist.model.ToDo;

@Service
public class ToDoServiceImpl implements ToDoService {

	@Autowired
	private ToDoMapper toDoMapper;

	@Override
	public List<ToDo> retrieveToDoListByUsername(String username) {
		return toDoMapper.retrieveToDoListByUsername(username);
	}

	@Override
	public ToDo retrieveToDoByUsernameAndId(String username, int todo_id) {
		return toDoMapper.retrieveToDoListByUsernameAndId(username, todo_id);
	}

	@Override
	public void deleteToDoByUsernameAndId(String username, int todo_id) {
		// we hope delete todo ... but not yet db connect
		System.out.println(">>> delete: " + username + ": " + todo_id);
	}

	@Override
	public ToDo updateToDoByUsernameAndId(String username, int todo_id, ToDo toDo) {
		// we hope update todo ... but not yet db connect
		System.out.println(">>> update: " + username + ": " + todo_id + ": " + toDo);
		return new ToDo(todo_id, username, toDo.getDescription(), false, toDo.getTarget_date());
	}

	@Override
	public ToDo insertToDoByUsername(String username, ToDo toDo) {
		// we hope insert todo ... but not yet db connect
		System.out.println(">>> insert: " + username + ": " + toDo);
		return new ToDo(99999, username, toDo.getDescription(), false, toDo.getTarget_date());
	}
	
}
