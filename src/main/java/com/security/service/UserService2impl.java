package com.security.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.security.model.User;
import com.security.repository.UserRepository;

@Service
@Transactional
public class UserService2impl implements UserService2{
	
	static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	@Autowired
	private PasswordEncoder passenc;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User save(User user) {
		String password = getPasswordHash(user.getPassword());
		user.setPassword(password);
		user.setCreatedDate(new Date());
		return userRepository.save(user);
	}

	private String getPasswordHash(String password) {
		return encoder.encode(password);
	}

}
