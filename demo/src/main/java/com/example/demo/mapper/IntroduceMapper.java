package com.example.demo.mapper;


import com.example.demo.domain.Club;
import com.example.demo.domain.Introduce;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

@Mapper
public interface IntroduceMapper {

    /**
     * 주어진 idx을 가진 동아리 소개 정보를 되돌린다.
     *
     * @param idx 동아리 idx
     * @return 동아리 소개 정보
     */
    public Introduce get(@Param("idx") Long idx);
}