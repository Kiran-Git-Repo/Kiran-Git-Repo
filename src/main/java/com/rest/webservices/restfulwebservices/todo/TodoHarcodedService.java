package com.rest.webservices.restfulwebservices.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoHarcodedService {
	
	private static List<Todo> todos=new ArrayList<>();
	private static long counter=0;

	static {
		todos.add(new Todo(++counter,"SuperUser","Learn to code in Angular",new Date(),false));
		todos.add(new Todo(++counter,"SuperUser","Learn to code in SpringBoot",new Date(),false));
		todos.add(new Todo(++counter,"SuperUser","Learn to connect angular and Springboot",new Date(),false));
	}
	
	public List<Todo> findAll(){
		return todos;
	}
	
	public Todo save(Todo todo) {
		if(todo.getId()==-1 || todo.getId()==0) {
			todo.setId(++counter);
			todos.add(todo);
		}
		else {
			deleteById(todo.getId());
			todos.add(todo);
			}
		return todo;
	}
	
	public Todo deleteById(long id) {
		Todo todo=findById(id);
		if(todo==null)
			return null;
		
		if(todos.remove(todo)){
		return todo;
		}
		
			return null;
	}

	public Todo findById(long id) {
		for(Todo todo:todos) {
			if(todo.getId()==id) {
				return todo;
			}
		}
		return null;
	}
	
	
	
}
