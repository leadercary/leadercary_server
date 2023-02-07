package com.example.demo.mapper;


import com.example.demo.domain.Post;
import com.example.demo.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Mapper
public interface PostMapper {

    /**
     * 주어진 idx을 가진 개시물 정보를 되돌린다.
     *
     * @param idx 개시물 idx
     * @return 개시물 정보
     */
    public Post get(@Param("idx") Long idx);

    /**
     * 주어진 idx을 가진 개시물 정보를 되돌린다.
     *
     * @param text text
     * @return list<개시물>
     */
    public List<Post> getByText(String text);

    /**
     * 주어진 idx을 가진 개시물 정보를 되돌린다.
     *
     * @param post post
     * @return 개시물 idx
     */
    public Long register(Post post);
}