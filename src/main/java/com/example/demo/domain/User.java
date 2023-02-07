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
     * 저장된 토큰
     */
    private String remember;

    /**
     * 토큰 만료 시간
     */
    private LocalDate remember_time;
}
