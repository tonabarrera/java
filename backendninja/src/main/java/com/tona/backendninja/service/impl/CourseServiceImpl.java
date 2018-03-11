package com.tona.backendninja.service.impl;

import com.tona.backendninja.entity.Course;
import com.tona.backendninja.repository.CourseJPARepository;
import com.tona.backendninja.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tona created on 10/03/2018 for backendninja.
 */
@Service("courseServiceImpl")
public class CourseServiceImpl implements CourseService{
    @Autowired
    @Qualifier("courseJPARepository")
    private CourseJPARepository courseJPARepository;

    @Override
    public List<Course> listAllCourses() {
        return courseJPARepository.findAll();
    }

    @Override
    public Course addCourse(Course course) {
        return courseJPARepository.save(course);
    }

    @Override
    public int removeCourse(int id) {
        courseJPARepository.deleteById(id);
        return 0;
    }

    @Override
    public Course updateCourse(Course course) {
        return courseJPARepository.save(course);
    }
}
