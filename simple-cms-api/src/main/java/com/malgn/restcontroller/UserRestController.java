package com.malgn.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.malgn.dto.LoginRequestDto;
import com.malgn.dto.LoginResponseDto;
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
	
	@PostMapping("/login")
	public LoginResponseDto login(@RequestBody LoginRequestDto loginRequestDto) {
		User user = userService.login(loginRequestDto.getUserId(), loginRequestDto.getUserPassword());
		return LoginResponseDto. builder()
				.userId(user.getUserId())
				.userName(user.getUserName())
				.userRole(user.getUserRole())
				.build();
	}
}
