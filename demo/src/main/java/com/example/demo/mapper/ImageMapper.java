package com.example.demo.mapper;


import com.example.demo.domain.Club;
import com.example.demo.domain.Image;
import com.example.demo.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

@Mapper
public interface ImageMapper {

    /**
     * 주어진 idx을 가진 사진 정보를 되돌린다.
     *
     * @param idx 사진 idx
     * @return 사진 정보
     */
    public Image get(@Param("idx") Long idx);

    /**
     * 이미지를 등록한다.
     *
     * @param image image
     * @return 이미지의 idx
     */
    public Long register(Image image);
}