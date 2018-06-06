package com.computeralchemist.configuration;

import com.computeralchemist.domain.users.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @Author
 * Karol Meksuła
 * 12-05-2018
 * */

public class CustomUserDetails extends User implements UserDetails {

    public CustomUserDetails(User user) {
        super(user);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> grantedAuthorities = new ConcurrentLinkedQueue<>();

        for (String role : super.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.toUpperCase()));
        }

        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getUsername();
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
