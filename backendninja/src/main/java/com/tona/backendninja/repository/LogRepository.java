package com.tona.backendninja.repository;

import com.tona.backendninja.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * @author tona created on 17/03/2018 for backendninja.
 */
@Repository("logRepository")

public interface LogRepository extends JpaRepository<Log, Serializable> {

}
