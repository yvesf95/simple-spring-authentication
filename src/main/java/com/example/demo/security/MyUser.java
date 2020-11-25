package com.example.demo.security;

import org.springframework.security.core.GrantedAuthority;
import com.example.demo.user.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MyUser implements UserDetails {
    private String username;
    private String password;
    private List<GrantedAuthority> authorities;

    public MyUser(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.authorities = Arrays.stream(user.getRoles().split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    public MyUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
