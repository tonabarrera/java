package com.tona.backendninja.service;

import com.tona.backendninja.entity.Course;
import com.tona.backendninja.model.CourseModel;

import java.util.List;

/**
 * @author tona created on 10/03/2018 for backendninja.
 */
public interface CourseService {
    List<CourseModel> listAllCourses();
    Course addCourse(CourseModel course);
    int removeCourse(int id);
    Course updateCourse(Course course);
}
