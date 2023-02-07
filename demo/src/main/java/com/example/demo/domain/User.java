package com.example.demo.domain;


import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    /**
     * idx
     */
    private Long idx;

    /**
     * 아이디
     */
    private String identity;

    /**
     * 비밀번호
     */
    private String password;

    /**
     * 권한
     */
    private String access;

    /**
     * 최종 접속 시간
     */
    private LocalDate last_time;
}
