package com.example.demo.controller;

import com.example.demo.domain.Post;
import com.example.demo.service.ImageService;
import com.example.demo.service.PostService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/post")
public class PostRestController {

    private final PostService postService;

    @PostMapping("/search")
    @ApiOperation(value = "getter", notes = "개시물 정보를 검색합니다.")
    private List<Post> search(@RequestParam(value = "text") String text) {
        return postService.search(text);
    }

    @PostMapping("/view")
    @ApiOperation(value = "getter", notes = "개시물 정보를 가져옵니다.")
    private Post view(@RequestParam(value = "idx") Long idx) {
        return postService.View(idx);
    }
}