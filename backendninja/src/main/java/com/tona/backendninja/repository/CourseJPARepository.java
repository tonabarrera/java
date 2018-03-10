package com.tona.backendninja.repository;

import com.tona.backendninja.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * @author tona created on 10/03/2018 for backendninja.
 */
@Repository("courseJPARepository")
public interface CourseJPARepository extends JpaRepository<Course, Serializable> {
     Course findByPrice(int price);
     Course findByPriceAAndName(int price, String name);
    List<Course> findByNameOrderByHours(String name);
    Course findByNameOrPrice(String name, int price);
}
