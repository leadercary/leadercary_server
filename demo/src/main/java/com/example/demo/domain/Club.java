package com.example.demo.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Club {
    /**
     * idx
     */
    private Long idx;

    /**
     * user_idx
     */
    private Long user_idx;

    /**
     * 로고 사진
     */
    private Long logo;

    /**
     * 이름
     */
    private String name;
}
