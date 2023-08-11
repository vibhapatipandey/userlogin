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
import com.app.user.login.utill.LoginUtill;

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
		if(!userRepository.isUserExists(user.getUserName())){
			return "error";
		}
		return "home";
	}
	
	
	@PostMapping("/register")
	public String processRegister(User user) {
		//BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = LoginUtill.encrypt(user.getPassword());
		user.setPassword(encodedPassword);
		
		if(userRepository.createUser(user)>0) {
			return "register_success";
		}
		return "registration_error";
	}
	
	@GetMapping("/registerNewUser")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());
		
		return "signup_form";
	}
	
	@GetMapping("/users")
	public String listUsers(Model model) {
		List<User> listUsers = userRepository.findAll();
		model.addAttribute("listUsers", listUsers);
		
		return "users";
	}
	
	
}
