package com.callor.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.todo.model.UserVO;
import com.callor.todo.service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	private UserService userService;
	
	
	public UserController(UserService userService) {
		this.userService = userService;
		
	}
	@RequestMapping(value="join",method=RequestMethod.GET)
	public String join() {
		
		return null;
	}
	@RequestMapping(value="join",method=RequestMethod.POST)
	public String join(UserVO userVO) {
		userService.insert(userVO);
		return "home";
	}
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login() {
		
		return null;
	}
	@RequestMapping(value="/mypage",method=RequestMethod.GET)
	public String mypage() {
		
		return null;
	}
	
}
