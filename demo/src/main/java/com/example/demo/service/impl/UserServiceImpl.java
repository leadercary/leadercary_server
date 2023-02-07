package com.example.demo.service.impl;

import com.example.demo.JwtTokenProvider;
import com.example.demo.SecurityConfig;
import com.example.demo.domain.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserServiceImpl implements UserService {
	private final UserMapper userMapper;
	private final PasswordEncoder passwordEncoder;
	private final JwtTokenProvider jwtTokenProvider;

	public User get(Long idx) {
		return this.userMapper.get(idx);
	}

	public User get(String identity) {
		return this.userMapper.getByIdentity(identity);
	}

	public String register(User user) {
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));
		user.setAccess("wait");
		LocalDate now = LocalDate.now();
		user.setLast_time(now);
		this.userMapper.register(user);
		return user.getIdentity();
	}

	public String login(User user) {
		if (this.passwordEncoder.matches(user.getPassword(), this.userMapper.getByIdentity(user.getIdentity()).getPassword())) {
			user = this.userMapper.getByIdentity(user.getIdentity());
			String userToken = jwtTokenProvider.createToken(user.getIdentity(), user.getAccess());
			LocalDate now = LocalDate.now();
			user.setLast_time(now);
			this.userMapper.updateAccessByIdentity(user);
			return userToken;
		} else {
			return "err";
		}
	}

	public void update(User user) {
		this.userMapper.update(user);
	}

	public void withdraw(Long idx) {
		this.userMapper.delete(idx);
	}

	public UserServiceImpl(final UserMapper userMapper, final PasswordEncoder passwordEncoder, final JwtTokenProvider jwtTokenProvider) {
		this.userMapper = userMapper;
		this.passwordEncoder = passwordEncoder;
		this.jwtTokenProvider = jwtTokenProvider;
	}
}
