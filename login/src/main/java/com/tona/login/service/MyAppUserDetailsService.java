package com.tona.login.service;

import com.tona.login.entity.Login;
import com.tona.login.repository.LoginRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service("userService")
public class MyAppUserDetailsService implements UserDetailsService {
    public static final Log LOG = LogFactory.getLog(MyAppUserDetailsService.class);

    @Autowired
    @Qualifier("loginRepository")
    private LoginRepository loginRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        LOG.info("loadUserByUsername() email = " + s);
        Login login = loginRepository.findByCorreo(s);
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        if (login != null)
            grantedAuthorities.add(new SimpleGrantedAuthority(login.getPersonal().getTipo()));

        return new User(login.getCorreo(), login.getPasswordhash(), grantedAuthorities);
    }
}
