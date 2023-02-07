package com.example.demo.service;

import com.example.demo.domain.Image;
import com.example.demo.domain.User;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

	/**
	 * 주어진 idx을 가진 사진 정보를 되돌린다.
	 * 
	 * @param idx 사진 idx
	 * @return 사진 정보
	 */
	public Image get(Long idx);

	/**
	 * 사진 정보를 압로드 한다.
	 *
	 * @param image 사진 정보
	 * @return 사진 정보
	 */
	public String upload(MultipartFile image) throws Exception;

	/**
	 * 사진 정보를 응답 한다.
	 *
	 * @param idx 사진 정보
	 * @return 사진 정보
	 */
	public String download(Long idx) throws Exception;

	/**
	 * 사진을 등록한다.
	 *
	 * @param image 사진 정보
	 * @return 사진 idx
	 */
	public Long register(Image image);
}
