package com.tona.backendninja.converter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author tona created on 17/03/2018 for backendninja.
 */
public class TestCrypt {
    private static final Log LOG = LogFactory.getLog(TestCrypt.class);
    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        LOG.info(passwordEncoder.encode("user"));
    }
}
