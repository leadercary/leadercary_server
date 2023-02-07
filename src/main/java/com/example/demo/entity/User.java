package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    /**
     * idx
     */
    private int Idx;

    /**
     * 아이디
     */
    private String identity;

    /**
     * 비밀번호
     */
    private String password;
}
