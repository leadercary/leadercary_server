package com.example.demo.service;

import com.example.demo.domain.Post;
import com.example.demo.domain.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface PostService {

	/**
	 * 주어진 idx을 가진 개시물 정보를 되돌린다.
	 * 
	 * @param idx 개시물 idx
	 * @return 개시물 정보
	 */
	public Post get(Long idx);

	/**
	 * 주어진 club_idx를 가진 개시물 정보를 되돌린다.
	 *
	 * @param club_idx club_idx
	 * @return 개시물 정보
	 */
	public List<Post> getByClub(Long club_idx);

	/**
	 * 주어진 키워드가 제목에 포함된 개시물 정보를 되돌린다.
	 * 
	 * @param text text
	 * @return 사용자 정보
	 */
	public List<Post> getByText(String text);

	/**
	 * 주어진 키워드가 포함된 개시물 정보를 되돌린다.
	 *
	 * @param text text
	 * @return 사용자 정보
	 */
	public List<Post> search(String text);

	/**
	 * 개시물을 등록한다.
	 * 
	 * @param post 개시물 정보
	 * @return idx
	 */
	public Long register(Post post, String text);

	/**
	 * 주어진 idx을 가진 포스터를 삭제 처리한다.
	 *
	 * @param idx idx
	 */
	public Long delete(Long idx);

	/**
	 * 주어진 idx을 가진 포스터를 열람 처리한다.
	 *
	 * @param idx idx
	 */
	public Post View(Long idx);
}
