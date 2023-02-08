package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Introduce {
    /**
     * idx
     */
    private Long idx;

    /**
     * detail
     */
    private String detail;

    /**
     * leader
     */
    private String leader;

    /**
     * 부원
     */
    private Long members;
}
