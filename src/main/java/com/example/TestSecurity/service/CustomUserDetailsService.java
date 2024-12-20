package com.example.TestSecurity.service;

import com.example.TestSecurity.dto.CustomUserDetails;
import com.example.TestSecurity.entity.UserEntity;
import com.example.TestSecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    // 로그인시 자동으로 username으로 UserEntiy를 찾아서 SecurityContext에 저장할 데이터로 변환후 저장.
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity userData = userRepository.findByusername(username);

        if (userData != null) {
            return new CustomUserDetails(userData);
        }
        return null;
    }
}
