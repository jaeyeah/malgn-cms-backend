package com.malgn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.malgn.entity.User;
import com.malgn.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	//회원가입
	public User join(User user) {
		if(userRepository.existsById(user.getUserId())) {
			throw new IllegalArgumentException("이미 사용중인 아이디입니다.");
		}
		user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
        if (user.getUserRole() == null || user.getUserRole().isBlank()) {
            user.setUserRole("USER");
        }
        return userRepository.save(user);
	}
	
	

}
