package com.kcbgroup.SoapWebservices.service;

import com.kcbgroup.SoapWebservices.enums.Status;
import com.kcbgroup.SoapWebservices.exceptions.UserNotFound;
import com.kcbgroup.SoapWebservices.model.Courses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@Slf4j
public class CourseDetailsService implements CourseDetailsInterface {

    static List<Courses> courseList = new ArrayList<>();

    static {
        Courses courses1 = new Courses(1, "Spring", "10 steps");
        courseList.add(courses1);

        Courses courses2 = new Courses(2, "Spring MVC", "10 examples");
        courseList.add(courses2);

        Courses courses3 = new Courses(3, "Spring Boot", "6K students");
        courseList.add(courses3);

        Courses courses4 = new Courses(4, "Maven", "most popular Maven Course");
        courseList.add(courses4);


    }


    @Override
    public Courses findById(int id) {
        for (Courses course : courseList) {

            if (course.getId() == id) {
                return course;

            } else {
                log.info("---------------NOT FOUND---------------");
               throw new UserNotFound(id + " not found");

            }
        }

        return null;
    }


    @Override
    public List<Courses> getAllCourses() {
        return courseList;
    }

    @Override
    public Status deleteById(int id) {
        Iterator<Courses> itr = courseList.iterator();
        try {
            itr.next();
        } catch (Exception e) {
            throw new RuntimeException("No such element");
        }
        while (itr.hasNext()) {
            Courses course = itr.next();
            if (course.getId() == id) {
                //courses.remove(course);
                itr.remove();
                return Status.SUCCESS;
            }
        }
        return Status.FAILURE;
    }
}
