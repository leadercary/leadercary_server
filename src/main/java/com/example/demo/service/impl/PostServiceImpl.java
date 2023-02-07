package com.example.demo.service.impl;

import com.example.demo.domain.Post;
import com.example.demo.domain.User;
import com.example.demo.mapper.ClubMapper;
import com.example.demo.mapper.PostMapper;
import com.example.demo.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Service
public class PostServiceImpl implements PostService {

	private final PostMapper postMapper;
	private final ClubMapper clubMapper;

	/**
	 * 주어진 idx을 가진 개시물 정보를 되돌린다.
	 * 
	 * @param idx 개시물 idx
	 * @return 개시물 정보
	 */
	@Override
	public Post get(Long idx) {
		return postMapper.get(idx);
	}

	/**
	 * 주어진 키워드가 포함된 개시물 정보를 되돌린다.
	 * 
	 * @param text text
	 * @return 사용자 정보
	 */
	@Override
	public List<Post> getByText(String text) {
		return postMapper.getByText(text);
	}

	/**
	 * 개시물을 등록한다.
	 * 
	 * @param post 개시물 정보
	 * @return idx
	 */
	@Override
	public Long register(Post post, String text) {
		LocalDateTime now = LocalDateTime.now();
		post.setCreate_time(now);
		post.setClub_idx(clubMapper.getByName(text).getIdx());
		System.out.println(post);
		return postMapper.register(post);
	}
}
