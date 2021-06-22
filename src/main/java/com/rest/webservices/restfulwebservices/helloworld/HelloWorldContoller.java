package com.rest.webservices.restfulwebservices.helloworld;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldContoller {
	@GetMapping("/helloworld")
	public String getMessageFrom() {
		return "Hello from Local host";
	}
	
	@GetMapping("/helloworld/bean")
	public HelloWorldBean getMessageFromBean() {
		return new HelloWorldBean("Hello from Spring");
	}
	
	@GetMapping("/helloworld/pathvariable/{name}")
	public HelloWorldBean getMessageWithName(@PathVariable String name) {
		return new HelloWorldBean("Hello from Spring"+name);
	}

}
