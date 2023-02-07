package com.example.demo.controller;

import com.example.demo.domain.Post;
import com.example.demo.service.PostService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/admin/post")
public class AdminRestController {

    private final PostService postService;

    @PostMapping("/create")
    @ApiOperation(value = "getter", notes = "새로운 포스트 정보를 업로드합니다.")
    private Long uploud(@RequestBody Post post,@RequestParam(value = "text") String text, @RequestHeader(value = "Authorization") String auth ) {
        System.out.println(auth);
        return postService.register(post, text);
    }

    @PostMapping("/delete")
    @ApiOperation(value = "getter", notes = "포스트 정보를 제거합니다.")
    private Long delete(@RequestParam(value = "idx") Long idx, @RequestHeader(value = "Authorization") String auth ) {
        System.out.println(auth);
        return postService.Delete(idx);
    }
}