package com.in28minutes.com.unittesting;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

	@GetMapping("/hello-world")
	public String helloWorld()
	{
		return "Hello World";
	}
}
