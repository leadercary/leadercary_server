package com.example.demo.controller;

import com.example.demo.domain.Post;
import com.example.demo.service.ImageService;
import com.example.demo.service.PostService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/post")
public class PostRestController {

    private final PostService postService;

    @PostMapping("/create")
    @ApiOperation(value = "getter", notes = "새로운 포스트 정보를 업로드합니다.")
    private Long uploud(@RequestBody Post post,@RequestParam(value = "text") String text) {
        return postService.register(post, text);
    }
    @PostMapping("/search")
    @ApiOperation(value = "getter", notes = "개시물 정보를 검색합니다.")
    private List<Post> search(String text) {
        return postService.getByText(text);
    }
}