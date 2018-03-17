package com.tona.backendninja.service;

import com.tona.backendninja.entity.UserRole;
import com.tona.backendninja.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author tona created on 17/03/2018 for backendninja.
 */
@Service("userService")
public class UserService implements UserDetailsService{
    @Autowired
    @Qualifier("userRepository")
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        com.tona.backendninja.entity.User user = userRepository.findByUsername(s);
        List<GrantedAuthority> authorities = buildAuthorities(user.getUserRoles());

        return buildUser(user, authorities);
    }

    private User buildUser(com.tona.backendninja.entity.User user,
            List<GrantedAuthority> authorities) {
        return new User(user.getUsername(), user.getPassword(), user.isEnabled(),
                true, true, true, authorities);
    }

    private List<GrantedAuthority> buildAuthorities(Set<UserRole> userRoles) {
        Set<GrantedAuthority> auths = new HashSet<>();
        for (UserRole role : userRoles) {
            auths.add(new SimpleGrantedAuthority(role.getRole()));
        }
        return new ArrayList<>(auths);
    }
}
