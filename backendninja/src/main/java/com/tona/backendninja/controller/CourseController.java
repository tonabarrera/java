package com.tona.backendninja.controller;

import com.tona.backendninja.entity.Course;
import com.tona.backendninja.service.CourseService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author tona created on 10/03/2018 for backendninja.
 */
@Controller
@RequestMapping("/courses")
public class CourseController {
    private static final String COURSES_VIEW = "courses";
    private static final Log LOG = LogFactory.getLog(CourseController.class);

    @Autowired
    @Qualifier("courseServiceImpl")
    private CourseService courseService;

    @GetMapping("/listcourses")
    public ModelAndView listCourses() {
        LOG.info("call listCourses()");
        ModelAndView modelAndView = new ModelAndView(COURSES_VIEW);
        modelAndView.addObject("course", new Course());
        modelAndView.addObject("courses", courseService.listAllCourses());
        return modelAndView;
    }

    @PostMapping("/addcourse")
    public String addCourse(@ModelAttribute("course") Course course) {
        LOG.info("call addCourse()");
        courseService.addCourse(course);
        return "redirect:/courses/listcourses";
    }
}
