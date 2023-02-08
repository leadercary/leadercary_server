package com.example.demo.service;

import com.example.demo.domain.Club;

public interface ClubService {

	/**
	 * 주어진 idx을 가진 동아리 정보를 되돌린다.
	 * 
	 * @param idx 동아리 idx
	 * @return 동아리 정보
	 */
	public Club get(Long idx);

	/**
	 * 주어진 이름을 가진 동아리 정보를 되돌린다.
	 * 
	 * @param name name
	 * @return 동아리 정보
	 */
	public Object getName(String name);

	/**
	 * 주어진 user_idx를 가진 동아리 정보를 되돌린다.
	 *
	 * @param user_idx user_idx
	 * @return 동아리 정보
	 */
	public Object getByUser(String user_idx);
}
