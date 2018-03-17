package com.tona.backendninja.repository;

import com.tona.backendninja.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * @author tona created on 16/03/2018 for backendninja.
 */
@Repository
public interface ContactRepository extends JpaRepository<Contact, Serializable>{}
