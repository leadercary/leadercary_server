package com.example.demo.mapper;


import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    /**
     * 주어진 idx을 가진 사용자 정보를 되돌린다.
     *
     * @param idx 사용자 idx
     * @return 사용자 정보
     */
    public User get(@Param("idx") int idx);

    /**
     * 주어진 아이디를 가진 사용자 정보를 되돌린다.
     *
     * @param identity identity
     * @return 사용자 정보
     */
    public User getByIdentity(@Param("identity") String identity);
}