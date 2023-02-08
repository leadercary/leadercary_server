package com.example.demo.service.impl;

import com.example.demo.domain.User;
import com.example.demo.domain.UserForSecurity;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service(value = "customUserDetailsService")
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService {
    private final UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userMapper.getByIdentity(username);

        if (user != null) {
            return UserForSecurity.builder()
                    .user(user)
                    .build();
        } else {
            throw new UsernameNotFoundException(username);
        }
    }
}
