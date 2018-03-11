package com.tona.backendninja.converter;

import com.tona.backendninja.entity.Course;
import com.tona.backendninja.model.CourseModel;
import org.springframework.stereotype.Component;

/**
 * @author tona created on 10/03/2018 for backendninja.
 */
@Component("courseConverter")
public class CourseConverter {
    public CourseModel entityToModel(Course course) {
        CourseModel courseModel = new CourseModel();
        courseModel.setName(course.getName());
        courseModel.setDescription(course.getDescription());
        courseModel.setHours(course.getHours());
        courseModel.setPrice(course.getPrice());

        return courseModel;
    }

    public Course ModelToEntity(CourseModel courseModel) {
        Course course = new Course();
        course.setName(courseModel.getName());
        course.setDescription(courseModel.getDescription());
        course.setHours(courseModel.getHours());
        course.setPrice(courseModel.getPrice());

        return course;
    }
}
