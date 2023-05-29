package com.leedohwan.todolist.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.leedohwan.todolist.model.ToDo;

@Mapper
public interface ToDoMapper {

//	List<Map<String, Object>> retrieveToDoListByUsername(String username);
	List<ToDo> retrieveToDoListByUsername(String username);
	
	ToDo retrieveToDoListByUsernameAndId(
			@Param("username") String username, @Param("todo_id") int todo_id);
}

