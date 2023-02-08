package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class UserForSecurity implements UserDetails {
    private static final long serialVersionUID =1L;

    @NonNull
    private User user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_USER");
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        authorities.add(authority);

        if (user.getAccess().equals("admin")) {
            authority = new SimpleGrantedAuthority("ROLE_ADMIN");
            authorities.add(authority);
        }

        if (user.getAccess().equals("master")) {
            authority = new SimpleGrantedAuthority("ROLE_MASTER");
            authorities.add(authority);

            authority = new SimpleGrantedAuthority("ROLE_ADMIN");
            authorities.add(authority);
        }

        return authorities;
    }

    @Override
    public String getPassword() {
        return ((user != null) ? user.getPassword() : null);
    }

    @Override
    public String getUsername() {
        return ((user != null) ? user.getIdentity() : null);
    }

    @Override
    public boolean isAccountNonExpired() {
        if (user != null) {
            return (user.getAccess().equals("wait"));
        }

        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() { return true; }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
