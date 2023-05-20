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
	
	@GetMapping("/user")
	public User retrieveUser() {
		return new User("user1", "pw1");
	}
	
	@GetMapping("/user/username/{username}")
	public User retrieveUserByUsername(@PathVariable String username) {
		return new User(username, "pw1");
	}
}
