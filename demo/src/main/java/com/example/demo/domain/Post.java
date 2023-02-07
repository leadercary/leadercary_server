package com.example.demo.domain;


import com.mysql.cj.log.Log;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    /**
     * idx
     */
    private Long idx;

    /**
     * club_idx
     */
    private Long club_idx;

    /**
     * 제목
     */
    private String title;

    /**
     * 내용
     */
    private String detail;

    /**
     * 생성일
     */
    private LocalDateTime create_time;

    /**
     * 조회수
     */
    private Long view;
}
