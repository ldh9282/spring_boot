package com.leedohwan.todolist.serviceUsingJPA;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leedohwan.todolist.modelUsingJPA.ToDo;
import com.leedohwan.todolist.repositoryUsingJPA.ToDoRepository;

@Service
public class ToDoServiceUsingJpaImpl implements ToDoServiceUsingJPA {

	@Autowired
	private ToDoRepository toDoRepository;

	@Override
	public List<ToDo> findByUsernameOrderByTargetDate(String username) {
		return toDoRepository.findByUsernameOrderByTargetDate(username);
	}
	
	@Override
	public List<ToDo> findByUsernameOrderByTargetDateDesc(String username) {
		return toDoRepository.findByUsernameOrderByTargetDateDesc(username);
	}

	@Override
	public ToDo findById(int id) {
		return toDoRepository.findById(id);
	}

	@Override
	public void deleteById(int id) {
		toDoRepository.deleteById(id);
	}
	

	@Override
	public ToDo save(ToDo toDo) {
		ToDo theToDo = toDoRepository.findById(toDo.getId());
		
		if (theToDo != null) {
			
			theToDo.setDescription(toDo.getDescription());
			theToDo.setDone(toDo.isDone());
			theToDo.setTargetDate(toDo.getTargetDate());
			return toDoRepository.save(theToDo);
		}
		
		toDo.setId(0);
		return toDoRepository.save(toDo);
		
	}


	
	
}
