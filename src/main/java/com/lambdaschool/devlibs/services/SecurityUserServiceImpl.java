package com.lambdaschool.devlibs.services;

import com.lambdaschool.devlibs.logging.Loggable;
import com.lambdaschool.devlibs.models.User;
import com.lambdaschool.devlibs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Loggable
@Transactional
@Service(value = "securityUserService")
public class SecurityUserServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userrepos;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userrepos.findByUsername(username.toLowerCase());
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername()
                .toLowerCase(),
                user.getPassword(),
                user.getAuthority());
    }
}
