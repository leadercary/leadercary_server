package com.example.demo.service.impl;

import com.example.demo.domain.Post;
import com.example.demo.mapper.ClubMapper;
import com.example.demo.mapper.PostMapper;
import com.example.demo.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.sampled.Port;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

	@Override
	public List<Post> getByClub(Long club_idx) {
		return postMapper.getByClub(club_idx);
	}

	/**
	 * 주어진 키워드가 제목에 포함된 개시물 정보를 되돌린다.
	 * 
	 * @param text text
	 * @return 사용자 정보
	 */
	@Override
	public List<Post> getByText(String text) {
		return postMapper.getByText(text);
	}
	
	/**
	 * 주어진 키워드가 포함된 개시물 정보를 되돌린다.
	 *
	 * @param text text
	 * @return 사용자 정보
	 */
	public List<Post> search(String text) {
		List<Post> list = new ArrayList<>();
		List<Post> plist = new ArrayList<>();
		list.addAll(postMapper.getByClub(clubMapper.getByNames(text).getIdx()));
		list.addAll(postMapper.getByText(text));

		Collections.sort(list, new PostComparator().reversed());

		list.addAll(plist);
		List<Post> lists = list.stream().distinct().collect(Collectors.toList());

		return lists;
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
		post.setClub_idx(clubMapper.getByNames(text).getIdx());
		return postMapper.register(post);
	}

	/**
	 * 주어진 idx을 가진 포스터를 삭제 처리한다.
	 *
	 * @param idx idx
	 */
	@Override
	public Long delete(Long idx) {
		postMapper.delete(idx);
		return idx;
	}

	public class PostComparator implements Comparator<Post> {
		@Override
		public int compare(Post post1, Post post2) {
			return Long.valueOf(java.sql.Timestamp.valueOf(post1.getCreate_time()).getTime())
					.compareTo(java.sql.Timestamp.valueOf(post2.getCreate_time()).getTime());
		}
	}

	/**
	 * 주어진 idx을 가진 포스터를 열람 처리한다.
	 *
	 * @param idx idx
	 */
	@Override
	public Post View(Long idx) {
		postMapper.addView(idx);
		Post post = postMapper.get(idx);
		return post;
	}
}
