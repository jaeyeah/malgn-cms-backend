package com.malgn.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.malgn.entity.User;
import com.malgn.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/api/user")
public class UserRestController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/join")
	public User join(@RequestBody User user) {
		return userService.join(user);
	}
	
//	@PostMapping("/login")
//	public User login(@RequestBody User user) {
//		return userService.login(user);
//	}
}
