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
     * @param club_idx club_idx
     * @return 개시물 정보
     */
    public List<Post> getByClub(@Param("club_idx") Long club_idx);

    /**
     * 주어진 텍스트를 가진 개시물 정보를 되돌린다.
     *
     * @param text text
     * @return list<개시물>
     */
    public List<Post> getByText(@Param("text") String text);

    /**
     * 주어진 idx을 가진 개시물 정보를 되돌린다.
     *
     * @param post post
     * @return 개시물 idx
     */
    public Long register(Post post);

    /**
     * 주어진 idx를 가진 포스터를 삭제한다.
     * @param idx idx
     */
    public void delete(@Param("idx") Long idx);

    /**
     * 주어진 idx를 가진 포스터의 뷰어를 증가한다.
     * @param idx idx
     */
    public void addView(@Param("idx") Long idx);
}