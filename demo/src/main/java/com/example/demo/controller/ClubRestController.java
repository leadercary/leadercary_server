package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.ClubService;
import com.example.demo.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/club")
public class ClubRestController {

    private final ClubService clubService;

    @PostMapping("/get")
    @ApiOperation(value = "getter", notes = "idx를 소지하는 club 정보를 모두 불러옵니다.")
    private Object get(@RequestParam(name = "idx") Long idx) {
        return clubService.get(idx);
    }

    @PostMapping("/getname")
    @ApiOperation(value = "getter", notes = "이름을 소지하는 club 정보를 모두 불러옵니다.")
    private Object getName(@RequestParam(name = "name") String name) {
        return clubService.getName(name);
    }
}