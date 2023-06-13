package com.leedohwan.todolist.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.leedohwan.todolist.model.ToDo;

@Mapper
public interface ToDoMapper {

	List<ToDo> retrieveToDoListByUsername(String username);
	
	ToDo retrieveToDoById(int id);
	
	void deleteToDoById(int todo_id);

	void updateToDo(ToDo toDo);

	void insertToDo(ToDo toDo);
}

