package com.example.demo.service.impl;

import com.example.demo.domain.Club;
import com.example.demo.mapper.ClubMapper;
import com.example.demo.service.ClubService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ClubServiceImpl implements ClubService {

	private final ClubMapper clubMapper;

	@Override
	public Club get(Long idx) {
		return clubMapper.get(idx);
	}

	@Override
	public Club get(String name) {
		return clubMapper.getByName(name);
	}

	public Club getByUser(String user_idx) {
		return clubMapper.getByName(user_idx);
	}
}
