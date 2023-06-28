package com.leedohwan.todolist.controller.page;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.leedohwan.todolist.model.User;

@RestController
public class Controller {
	
	@GetMapping("/hello-world")
	public String helloWorld() {
		return "hello world!!!";
	}
	
}
