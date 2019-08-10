package com.posiftm.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.posiftm.course.entities.User;

@RestController
@RequestMapping(value="/users")

public class UserResource {
	
    @GetMapping
	public ResponseEntity<User> findAll(){
		
		User u = new User(1L, "Clayton", "clayton.iftm@gmail.com", "88884772", "123456");
		return ResponseEntity.ok().body(u);
}
}