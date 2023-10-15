package com.project.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class healthController {
	
	@Value("${app.version}")
	private String ver;
	@GetMapping("/ver")
	public String getVersion() {
		return "Application is up and Running with version "+ver;
	}

}
