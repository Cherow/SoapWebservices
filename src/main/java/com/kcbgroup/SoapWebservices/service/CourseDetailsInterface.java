package com.kcbgroup.SoapWebservices.service;

import com.in28minutes.courses.CourseDetails;
import com.kcbgroup.SoapWebservices.enums.Status;
import com.kcbgroup.SoapWebservices.model.Courses;

import java.util.ArrayList;
import java.util.List;

public interface CourseDetailsInterface {

    //static list of courses






    //METHODS
    //find one course by id

    Courses findById(int id);
    //get all course details


    List<Courses> getAllCourses();
    //delete courses
    Status deleteById (int id);


    //updating courses and new courses
}
