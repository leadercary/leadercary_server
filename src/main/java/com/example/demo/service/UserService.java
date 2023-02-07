package com.example.demo.service;

import com.example.demo.domain.User;

public interface UserService {

	/**
	 * 주어진 idx을 가진 사용자 정보를 되돌린다.
	 * 
	 * @param idx 사용자 idx
	 * @return 사용자 정보
	 */
	public User get(Long idx);

	/**
	 * 주어진 아이디를 가진 사용자 정보를 되돌린다.
	 * 
	 * @param identity identity
	 * @return 사용자 정보
	 */
	public User get(String identity);

	/**
	 * 사용자를 등록한다.
	 * 
	 * @param user 사용자 정보
	 * @return 토큰
	 */
	public String register(User user);

	/**
	 * 만료일을 갱신한다.
	 *
	 * @param user 사용자 정보
	 * @return 토큰
	 */
	public String renewal(User user);

	/**
	 * 토큰과 만료일을 갱신한다.
	 *
	 * @param user 사용자 정보
	 * @return 토큰
	 */
	public String login(User user);

	/**
	 * 사용자 정보를 갱신한다.
	 * 
	 * @param user 사용자 정보
	 */
	public void update(User user);

	/**
	 * 주어진 idx을 가진 회원을 탈퇴 처리한다.
	 * 
	 * @param idx idx
	 */
	public void withdraw(Long idx);

}
