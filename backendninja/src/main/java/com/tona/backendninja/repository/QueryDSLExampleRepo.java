package com.tona.backendninja.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import com.tona.backendninja.entity.Course;
import com.tona.backendninja.entity.QCourse;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author tona created on 10/03/2018 for backendninja.
 */
@Repository("queryDSLExampleRepo")
public class QueryDSLExampleRepo {
    private QCourse qCourse = QCourse.course;

    @PersistenceContext
    private EntityManager manager;

    public Course find(boolean exist) {
        JPAQuery<Course> query = new JPAQuery<Course>(manager);
        BooleanBuilder builder = new BooleanBuilder(qCourse.description.endsWith("OP"));
        if (exist)
            builder.and(qCourse.id.eq(23));
        else
            builder.or(qCourse.name.endsWith("OP"));

        return query.select(qCourse).from(qCourse).where(builder).fetchOne();
        //        .from(qCourse).where(qCourse.id.eq(23)).fetchOne();
        //Course course23 = (Course) query.select(qCourse.name, qCourse.description)
        //        .from(qCourse).where(qCourse.id.eq(23)).fetchOne();

        //List<Course> courses = query.select(qCourse).from(qCourse)
        //        .where(qCourse.hours.between(20, 50)).fetch();
    }
}
