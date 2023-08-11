package com.app.user.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.user.login.pojo.User;
import com.app.user.login.repository.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	
	@GetMapping("/")
	public String login(Model model) {
		User user =new User();
		model.addAttribute("user", user);
		return "login";
	}

	@PostMapping("/userLogin")
	public String loginUser(@ModelAttribute("user")User user) {
		System.out.println(user.getUserName());
		System.out.println(user.getPassword());
		return "home";
	}
	
	
	@GetMapping(path="/userName")
	public List<String> getUserName(){
		
		return userRepository.getUserName();
	}
}
