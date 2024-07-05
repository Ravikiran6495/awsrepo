package com.example.demo;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:4200/")
public class StudentController {

	@GetMapping("name")
	public String name() {
		return "ram";
	}
	
	@GetMapping("welcome")
	public String welcome() {
		return "welcome to aws";
	}
	
	@PostMapping("add")
	public int addition(@RequestBody Request request) {
		System.out.println(request);
		return request.getNum1()+request.getNum2();
	}
}
