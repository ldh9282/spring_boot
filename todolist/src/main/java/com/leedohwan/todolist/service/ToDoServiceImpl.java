package com.leedohwan.todolist.service;

import java.time.ZoneId;
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
	public ToDo retrieveToDoById(int todo_id) {
		return toDoMapper.retrieveToDoById(todo_id);
	}

	@Override
	public void deleteToDoById(int todo_id) {
		toDoMapper.deleteToDoById(todo_id);
	}

	@Override
	public void updateToDo(ToDo toDo) {
		ZoneId zone = ZoneId.of("GMT+09");
		toDo.setTarget_date(toDo.getTarget_date().withZoneSameInstant(zone));
		toDoMapper.updateToDo(toDo);
	}

	@Override
	public void insertToDo(ToDo toDo) {
		ZoneId zone = ZoneId.of("GMT+09");
		toDo.setTarget_date(toDo.getTarget_date().withZoneSameInstant(zone));
		toDoMapper.insertToDo(toDo);
	}
	
}
