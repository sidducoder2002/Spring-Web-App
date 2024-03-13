package com.taashee.SpringWebApp.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taashee.SpringWebApp.CustomAppconfiguration;
import com.taashee.SpringWebApp.entity.States;

//@Component
//@ResponseBody
@Controller
@RestController
@RequestMapping("/hello")
public class HelloWorldController {
	@Autowired
	CustomAppconfiguration customAppconfiguration;
//	@GetMapping
//	public String Hello() {
//		return "Hello world";
//	}
	@RequestMapping(path="/states")
	public List<States> getAllStates(){
		return  Arrays.asList(new States(1,"Telangana", "TS" ,123,"Hyderabad"));
	}
	@GetMapping("/taashee")
	public String getTaasheeInfo() {
		return customAppconfiguration.getUrl() + customAppconfiguration.getCity();
 	}
	
	
}
