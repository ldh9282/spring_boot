package com.leedohwan.todolist.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.leedohwan.todolist.model.ToDo;

@Service
public class ToDoServiceImpl implements ToDoService {

//	@Autowired
//	private ToDoDao toDoDao;

	@Override
	public List<ToDo> retrieveToDoListByUsername(String username) {
		ToDo toDo1 = new ToDo(1, username, "Eating", false, LocalDateTime.of(2023, 5, 21, 11, 59, 59));
		ToDo toDo2 = new ToDo(2, username, "Sleeping", true, LocalDateTime.of(2023, 5, 22, 11, 59, 59));
		
		List<ToDo> toDos = new ArrayList<>();
		toDos.add(toDo1);
		toDos.add(toDo2);
		return toDos;
	}

	@Override
	public ToDo retrieveToDoByUsernameAndId(String username, int todo_id) {
		ToDo toDo1 = new ToDo(1, username, "Eating", false, LocalDateTime.of(2023, 5, 21, 11, 59, 59));
		ToDo toDo2 = new ToDo(2, username, "Sleeping", true, LocalDateTime.of(2023, 5, 22, 11, 59, 59));
		
		if (todo_id == 1) {
			return toDo1;
		} else {
			return toDo2;
		}
	}

	@Override
	public void deleteToDoByUsernameAndId(String username, int todo_id) {
		// we hope delete todo ... but not yet db connect 
	}
	
}
