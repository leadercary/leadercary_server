package com.example.demo.service.impl;

import com.example.demo.domain.Club;
import com.example.demo.domain.Introduce;
import com.example.demo.domain.Plus;
import com.example.demo.mapper.ClubMapper;
import com.example.demo.mapper.IntroduceMapper;
import com.example.demo.service.ClubService;
import com.mysql.cj.xdevapi.JsonArray;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@AllArgsConstructor
@Service
public class ClubServiceImpl implements ClubService {

	private final ClubMapper clubMapper;
	private final IntroduceMapper introduceMapper;

	@Override
	public Club get(Long idx) {
		return clubMapper.get(idx);
	}

	@Override
	public Object getName(String name) {
		Club club = clubMapper.getByNames(name);
		Introduce introduce = introduceMapper.get(club.getIdx());
		Plus plus = new Plus();
		plus.setIdx(club.getIdx());
		plus.setName(club.getName());
		plus.setDetail((introduce.getDetail()));
		plus.setLeader(introduce.getLeader());
		plus.setLogo(club.getLogo());
		plus.setUser_idx(club.getUser_idx());

		return plus;
	}

	public Object getByUser(String user_idx) {
		return clubMapper.getByName(user_idx);
	}
}
