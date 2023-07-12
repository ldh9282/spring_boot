package com.leedohwan.todolist.repositoryUsingJPA;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leedohwan.todolist.modelUsingJPA.ToDo;


/***
 * 
 * @model ToDo
 * @id Integer
 *
 */
@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Integer> {

	List<ToDo> findByUsernameOrderByTargetDate(String username);
	
	List<ToDo> findByUsernameOrderByTargetDateDesc(String username);
	
	ToDo findById(int id);
	
	void deleteById(int id);
	
	ToDo save(ToDo toDo);

}
