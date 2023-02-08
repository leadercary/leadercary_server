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

import java.util.HashMap;

@RestController
@AllArgsConstructor
@RequestMapping("/api/image")
public class ImageRestController {

    private final ImageService imageService;

    @PostMapping("/upload")
    @ApiOperation(value = "getter", notes = "새로운 사진 정보를 업로드합니다.")
    private HashMap<String ,String> uploud(MultipartFile image) throws Exception {
        HashMap<String ,String> map = new HashMap<>() {{
            put("idx", imageService.upload(image));
        }};
        return map;
    }
    @PostMapping("/get")
    @ApiOperation(value = "getter", notes = "새로운 사진 주소를 응답합니다.")
    private HashMap<String ,String> get(@RequestParam(value = "idx") Long idx) throws Exception {
        HashMap<String ,String> map = new HashMap<>() {{
            put("uri", imageService.get(idx).getPath());
        }};
        return map;
    }
}