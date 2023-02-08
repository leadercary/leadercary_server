package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
public class UserRestController {

    private final UserService userService;

    @PostMapping("/signup")
    @ApiOperation(value = "getter", notes = "새로운 사용자 정보를 주입합니다. 추가적으로 즉시 토큰을 발급받습니다.")
    private HashMap<String ,String> create_user(@RequestBody User user) {
        HashMap<String ,String> map = new HashMap<>() {{
            put("idx", userService.register(user));
        }};
        return map;
    }
    @PostMapping("/signin")
    @ApiOperation(value = "getter", notes = "토큰이 없거나 만료될시 다시 로그인을 시도할때 사용됩니다.")
    private HashMap<String ,String> sginin(@RequestBody User user) {
        HashMap<String ,String> map = new HashMap<>() {{
            put("idx", userService.login(user));
        }};
        return map;
    }
}