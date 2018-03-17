package com.tona.backendninja.repository;

import com.tona.backendninja.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * @author tona created on 17/03/2018 for backendninja.
 */
@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Serializable>{
    User findByUsername(String username);
}
