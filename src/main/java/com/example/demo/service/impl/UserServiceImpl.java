package com.example.demo.service.impl;

import com.example.demo.domain.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Random;

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
		user.setRemember(random_string());
		LocalDate now = LocalDate.now();
		user.setRemember_time(now.plusDays(30));
		userMapper.register(user);
		return user.getRemember();
	}

	@Override
	public String renewal(User user) {
		System.out.println(user);
		String token = userMapper.getByIdentity(user.getIdentity()).getRemember();
		System.out.println(userMapper.getByIdentity(user.getIdentity()));
		System.out.println(token);
		if(token.equals(user.getRemember())) {
			LocalDate now = LocalDate.now();
			user.setRemember_time(now.plusDays(30));
			userMapper.updateRememberByIdentity(user);
			return user.getRemember();
		} else {
			return "err";
		}
	}

	@Override
	public String login(User user) {
		if(passwordEncoder.matches(user.getPassword(), userMapper.getByIdentity(user.getIdentity()).getPassword())) {
			user.setRemember(random_string());
			LocalDate now = LocalDate.now();
			user.setRemember_time(now.plusDays(30));
			userMapper.updateRememberByIdentity(user);
			return user.getRemember();
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

	public String random_string() {
		Random random = new Random();

		return  random.ints(48,123)
				.filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
				.limit(30)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
				.toString();
	}
}
