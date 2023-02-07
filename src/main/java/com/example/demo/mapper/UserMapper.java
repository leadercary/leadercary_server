package com.example.demo.mapper;


import com.example.demo.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

@Mapper
public interface UserMapper {

    /**
     * 주어진 idx을 가진 사용자 정보를 되돌린다.
     *
     * @param idx 사용자 idx
     * @return 사용자 정보
     */
    public User get(@Param("idx") Long idx);

    /**
     * 주어진 아이디를 가진 사용자 정보를 되돌린다.
     *
     * @param identity Identity
     * @return 사용자 정보
     */
    public User getByIdentity(@Param("identity") String identity);

    /**
     * 사용자를 등록한다.
     *
     * @param user 사용자 정보
     * @return 등록된 사용자의 idx
     */
    public Long register(User user);

    /**
     * 사용자 정보를 갱신한다.
     * @param user 사용자 정보
     */
    public void update(User user);

    /**
     * 사용자의 토큰 관련 정보를 갱신한다.
     * @param user 사용자 정보
     */
    public void updateRememberByIdentity(User user);

    /**
     * 주어진 idx를 가진 회원을 삭제한다.
     * @param idx idx
     */
    public void delete(@Param("idx") Long idx);
}