package com.codegym.casetudy.service;

import com.codegym.casetudy.model.employee.User;
import com.codegym.casetudy.repository.IUserRepository;
import com.codegym.casetudy.model.employee.MyUserDetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = iUserRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User name: " + username + " not found");
        }

        return new MyUserDetail(user);
    }
}
