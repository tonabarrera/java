package com.tona.backendninja.service;

import com.tona.backendninja.entity.Course;

import java.util.List;

/**
 * @author tona created on 10/03/2018 for backendninja.
 */
public interface CourseService {
    List<Course> listAllCourses();
    Course addCourse(Course course);
    int removeCourse(int id);
    Course updateCourse(Course course);
}
