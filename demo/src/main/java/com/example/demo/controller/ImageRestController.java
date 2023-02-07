package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.mapper.ImageMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.ImageService;
import com.example.demo.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@AllArgsConstructor
@RequestMapping("/api/image")
public class ImageRestController {

    private final ImageService imageService;

    @PostMapping("/upload")
    @ApiOperation(value = "getter", notes = "새로운 사진 정보를 업로드합니다.")
    private String uploud(MultipartFile image) throws Exception {
        return imageService.upload(image);
    }
}