package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Image {
    /**
     * idx
     */
    private Long idx;

    /**
     * path
     */
    private String path;

    /**
     * size
     */
    private Long size;
}
