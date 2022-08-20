package com.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.LoginUser;
import com.employee.entity.User;
import com.employee.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private ObjectMapper mapper;

	@PostMapping("/login")
	public String login(@RequestBody(required = true) LoginUser loginUser) throws JsonProcessingException {

		return mapper.writeValueAsString(userService.performLogin(loginUser.getUsername(), loginUser.getPassword()));
	}

	@PostMapping(path = "/addUser")
	public String addUser(@RequestBody(required = true) User user) throws JsonProcessingException {
		
		return mapper.writeValueAsString(userService.addUser(user));
	}

	@GetMapping(path = "/getAllUser")
	public String getAllUser() throws JsonProcessingException {

		return mapper.writeValueAsString(userService.getAllUser());
	}

	@PostMapping(path = "/updateUser")
	public String updateUser(@RequestBody(required = true) User user) throws JsonProcessingException {
		
		
		return mapper.writeValueAsString(userService.updateUser(user));
	}

	@GetMapping(value = "/getUserById")
	public String getUserById(@RequestParam(name = "userId", required = true) long userId)
			throws JsonProcessingException {

		return mapper.writeValueAsString(userService.getUser(userId));
	}

	@GetMapping(path = "/deleteUser")
	public String deleteUser(@RequestParam(name = "userId", required = true) long userId)
			throws JsonProcessingException {

		return mapper.writeValueAsString(userService.deleteUser(userId));
	}
}
