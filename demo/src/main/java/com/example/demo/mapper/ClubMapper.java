package com.example.demo.mapper;


import com.example.demo.domain.Club;
import com.example.demo.domain.Post;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

@Mapper
public interface ClubMapper {

    /**
     * 주어진 idx을 가진 동아리 정보를 되돌린다.
     *
     * @param idx 동아리 idx
     * @return 동아리 정보
     */
    public Club get(@Param("idx") Long idx);

    /**
     * 주어진 이름을 가진 동아리 정보를 되돌린다.
     *
     * @param text text
     * @return 동아리 정보
     */
    public Object getByName(@Param("text") String text);

    /**
     * 주어진 이름을 가진 동아리 정보를 되돌린다.
     *
     * @param text text
     * @return 동아리 정보
     */
    public Club getByNames(@Param("text") String text);

    /**
     * 주어진 사용자 이름을 가진 동아리 정보를 되돌린다.
     *
     * @param user_idx name
     * @return 동아리 정보
     */
    public Club getByUser(@Param("user_idx") String user_idx);
}