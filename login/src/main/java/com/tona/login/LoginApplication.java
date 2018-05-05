package com.tona.login;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class LoginApplication {
    //public static final Log LOG = LogFactory.getLog(LoginApplication.class);

    public static void main(String[] args) {
        //BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        //LOG.info("Hola = " +  encoder.encode("hola"));
        SpringApplication.run(LoginApplication.class, args);
    }
}
