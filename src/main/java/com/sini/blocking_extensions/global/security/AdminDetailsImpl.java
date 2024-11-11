package com.sini.blocking_extensions.global.security;

import com.sini.blocking_extensions.entity.Admin;
import java.util.Collection;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Getter
public class AdminDetailsImpl implements UserDetails {

    private final Admin admin;

    public AdminDetailsImpl(Admin admin) {
        this.admin = admin;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public Long getUserId(){
        return admin.getId();
    }

    public String getEmail() {
        return admin.getEmail();
    }

    @Override
    public String getUsername() {
        return admin.getNickname();
    }
    @Override
    public String getPassword() {
        return admin.getPassword();
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
