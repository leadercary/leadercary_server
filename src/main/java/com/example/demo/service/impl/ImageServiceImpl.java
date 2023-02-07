package com.example.demo.service.impl;

import com.example.demo.domain.Image;
import com.example.demo.domain.User;
import com.example.demo.mapper.ImageMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.ImageService;
import com.example.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Tuple;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

@AllArgsConstructor
@Service
public class ImageServiceImpl implements ImageService {

	private final ImageMapper imageMapper;

	/**
	 * 사진 정보를 가져옵니다.
	 *
	 * @param idx
	 * @return 사진 정보
	 */
	@Override
	public Image get(Long idx) {
		return imageMapper.get(idx);
	}
	
	/**
	 * 사진 정보를 압로드 한다.
	 *
	 * @param image 사진 정보
	 * @return 사진 정보
	 */
	@Override
	public String upload(@RequestParam("image") MultipartFile image) throws Exception {
		String imagePath = null;
		String absolutePath = new File("").getAbsolutePath() + "\\";
		String path = "build\\resources\\main\\file\\images";
		File file = new File(path);
		if (!file.exists()) {
			file.mkdirs();
		}

		if (!image.isEmpty()) {
			String contentType = image.getContentType();
			String originalFileExtension;
			if (ObjectUtils.isEmpty(contentType)) {
				return "이미지 파일은 jpg, png 만 가능합니다.";
			} else {
				if (contentType.contains("image/jpeg")) {
					originalFileExtension = ".jpg";
				} else if (contentType.contains("image/png")) {
					originalFileExtension = ".png";
				} else {
					return "이미지 파일은 jpg, png 만 가능합니다.";
				}
			}
			LocalDateTime now = LocalDateTime.now();
			imagePath = path + "\\" + now.format(DateTimeFormatter.ofPattern("yyyyMMDDHHmmssnnnn")) + originalFileExtension;
			file = new File(absolutePath + imagePath);
			image.transferTo(file);
			Image res = new Image();
			res.setSize(Files.size(Paths.get(absolutePath + imagePath)));
			res.setPath(absolutePath + imagePath);
			register(res);
		}
		else {
			return "이미지 파일이 비어있습니다.";
		}

		return imagePath;
	}

	/**
	 * 사진 정보를 응답 한다.
	 *
	 * @param idx 사진 정보
	 * @return 사진 정보
	 */
	@Override
	public String download(Long idx) throws Exception {
		imageMapper.get(idx).getPath();
		return "";
	}

	/**
	 * 사진을 등록한다.
	 *
	 * @param image 사진 정보
	 * @return 사진 idx
	 */
	@Override
	public Long register(Image image) {
		return imageMapper.register(image);
	}
}
