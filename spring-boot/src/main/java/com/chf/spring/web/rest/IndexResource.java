package com.chf.spring.web.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexResource {

	@RequestMapping(method = RequestMethod.GET)
	public String welcome() {
		return "Welcome to spring.";
	}

}
