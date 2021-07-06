package com.rest.webservices.restfulwebservices.todo;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@CrossOrigin("*")
public class TodoJpaResource {
	
	@Autowired
	private TodoJPARepository todoJpaRepo;
	
	@Autowired
	private TodoHarcodedService todoService;
	
	@GetMapping("/jpa/users/{userName}/todos")
	public List<Todo> getAllTodos(@PathVariable String userName) {
		
		return todoJpaRepo.findByuserName(userName);
		
	}
	
	@DeleteMapping("/jpa//users/{userName}/todo/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String userName,@PathVariable long id){
		
		//Todo todo = todoService.deleteById(id);
		todoJpaRepo.deleteById(id);
		
			return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/jpa/users/{userName}/todo/{id}")
	public Todo getTodo(@PathVariable String userName,@PathVariable long id) {
		
		return todoJpaRepo.findById(id).get();
		
	}
	
	@PutMapping("/jpa/users/{userName}/todo/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable String userName,@PathVariable long id,
			@RequestBody Todo todo){
		
		Todo updatedTodo=todoJpaRepo.save(todo);
		
		return new ResponseEntity<Todo>(updatedTodo, HttpStatus.OK);
		
	}
	
	@PostMapping("/jpa/users/{userName}/todo")
	public ResponseEntity<Todo> saveTodo(@PathVariable String userName,
			@RequestBody Todo todo){
		
		todo.setUserName(userName);
		Todo createdTodo=todoJpaRepo.save(todo);
		
		
		URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(createdTodo.getId()).toUri();
		return  ResponseEntity.created(uri).build();
		
	}
}
