package com.computeralchemist.configuration;

import com.computeralchemist.domain.users.User;
import com.computeralchemist.repository.users.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @Author
 * Karol Meksuła
 * 12-05-2018
 * */

@Component
public class UserDetailsServiceImpl implements UserDetailsService {
    private UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findByUsername(username);

        userOptional.orElseThrow(() -> new UsernameNotFoundException("User not exist, or bad credencials."));

        return userOptional.map(CustomUserDetails::new).get();
    }

}
