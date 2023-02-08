package com.example.demo.controller;

import com.example.demo.domain.Post;
import com.example.demo.service.PostService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminRestController {

    private final PostService postService;

    @PostMapping("/create")
    @ApiOperation(value = "getter", notes = "새로운 포스트 정보를 업로드합니다.")
    private HashMap<String ,Long> uploud(@RequestBody Post post,
                                     @RequestParam(value = "text") String text,
                                     @RequestHeader(value = "Authorization") String auth ,
                                     HttpServletRequest request) {
        HashMap<String ,Long> map = new HashMap<>() {{
            put("idx", postService.register(post, text));
        }};
        return map;
    }

    @PostMapping("/delete")
    @ApiOperation(value = "getter", notes = "포스트 정보를 삭제합니다.")
    private HashMap<String ,Long> delete(@RequestParam(value = "idx") Long idx,
                        @RequestHeader(value = "Authorization") String auth,
                        HttpServletRequest request) {
        HashMap<String ,Long> map = new HashMap<>() {{
            put("idx", postService.delete(idx));
        }};
        return map;
    }
}