package com.example.demo.service.impl;

import com.example.demo.SecurityConfig;
import com.example.demo.domain.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

	private final UserMapper userMapper;
	private final PasswordEncoder passwordEncoder;

	@Override
	public User get(Long idx) {
		return userMapper.get(idx);
	}

	@Override
	public User get(String identity) {
		return userMapper.getByIdentity(identity);
	}
	
	@Override
	public String register(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setAccess("wait");
		LocalDate now = LocalDate.now();
		user.setLast_time(now);
		userMapper.register(user);
		return user.getIdentity();
	}

	@Override
	public String login(User user) {
		if(passwordEncoder.matches(user.getPassword(), userMapper.getByIdentity(user.getIdentity()).getPassword())) {
			user = userMapper.getByIdentity(user.getIdentity());
			String userToken = SecurityConfig.CreateToken(user.getIdentity(), user.getAccess());

			LocalDate now = LocalDate.now();
			user.setLast_time(now);
			userMapper.updateAccessByIdentity(user);

			return userToken;
		} else {
			return "err";
		}
	}

	@Override
	public void update(User user) {
		userMapper.update(user);
	}

	@Override
	public void withdraw(Long idx) {
		userMapper.delete(idx);
	}
}
