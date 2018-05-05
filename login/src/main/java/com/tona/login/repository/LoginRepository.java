package com.tona.login.repository;

import com.tona.login.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("loginRepository")
public interface LoginRepository extends JpaRepository<Login, Serializable> {
    Login findByCorreo(String correo);
}
