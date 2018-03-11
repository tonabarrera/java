package com.tona.backendninja.service.impl;

import com.tona.backendninja.converter.CourseConverter;
import com.tona.backendninja.entity.Course;
import com.tona.backendninja.model.CourseModel;
import com.tona.backendninja.repository.CourseJPARepository;
import com.tona.backendninja.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tona created on 10/03/2018 for backendninja.
 */
@Service("courseServiceImpl")
public class CourseServiceImpl implements CourseService{
    @Autowired
    @Qualifier("courseJPARepository")
    private CourseJPARepository courseJPARepository;


    @Autowired
    @Qualifier("courseConverter")
    private CourseConverter courseConverter;


    @Override
    public List<CourseModel> listAllCourses() {
        List<CourseModel> modelList = new ArrayList<>();
        for (Course curso : courseJPARepository.findAll()) {
            modelList.add(new CourseModel(curso.getName(), curso.getDescription(),
                    curso.getPrice(), curso.getHours()));
        }
        return modelList;
    }

    @Override
    public Course addCourse(CourseModel course) {
        return courseJPARepository.save(courseConverter.ModelToEntity(course));
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
