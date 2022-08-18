package com.kcbgroup.SoapWebservices.soap;

import com.in28minutes.courses.*;
import com.kcbgroup.SoapWebservices.enums.Status;
import com.kcbgroup.SoapWebservices.exceptions.UserNotFound;
import com.kcbgroup.SoapWebservices.model.Courses;
import com.kcbgroup.SoapWebservices.service.CourseDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint

public class CourseDetailsEndPoints {
    @Autowired


    private CourseDetailsService courseDetailsService;
    //create a method
    //input --request---GetCourseDetailsRequest
    //output -- response--GetCourseDetailsResponse
    //http://in28minutes.com/courses
    //GetCourseDetailRequest
    @PayloadRoot(namespace = "http://in28minutes.com/courses"
            , localPart = "GetCourseDetailsRequest")
    @ResponsePayload
    public GetCourseDetailsResponse processCourseDetails(@RequestPayload GetCourseDetailsRequest request) {
        Courses course = courseDetailsService.findById(request.getId());

        return mapCourseDetails(course);
    }

    private GetCourseDetailsResponse mapCourseDetails(Courses course) {
        GetCourseDetailsResponse response = new GetCourseDetailsResponse();
        CourseDetails courseDetails = mapCourse(course);
        response.setCourseDetails(courseDetails);
        return response;
    }
    private GetALLCourseDetailsResponse mapALLCourseDetails(List<Courses> course) {
        GetALLCourseDetailsResponse response =  new GetALLCourseDetailsResponse();
        for(Courses courses : course){
            CourseDetails mapCourse = mapCourse(courses);
            response.getCourseDetails().add(mapCourse);
        }
        return response;
    }

    private CourseDetails mapCourse(Courses course) {
        CourseDetails courseDetails = new CourseDetails();
        courseDetails.setId(course.getId());
        courseDetails.setDescription(course.getDescription());
        courseDetails.setName(course.getName());
        return courseDetails;
    }


    @PayloadRoot(namespace = "http://in28minutes.com/courses"
            , localPart = "GetALLCourseDetailsRequest")
    @ResponsePayload
    public GetALLCourseDetailsResponse processCourseDetails(@RequestPayload GetALLCourseDetailsRequest request) {
         List<Courses> courses = courseDetailsService.getAllCourses();
         GetALLCourseDetailsResponse getALLCourseDetailsResponse = mapALLCourseDetails(courses);


       return getALLCourseDetailsResponse;
    }


    @PayloadRoot(namespace = "http://in28minutes.com/courses"
            , localPart = "DeleteCourseDetailsRequest")
    @ResponsePayload
    public DeleteCourseDetailsResponse deleteCourseDetails(@RequestPayload DeleteCourseDetailsRequest request) {
        DeleteCourseDetailsResponse response = new DeleteCourseDetailsResponse();
        Status courses = courseDetailsService.deleteById(request.getId());
        response.setStatus(mapStatus(courses));


        return response;
    }

    private com.in28minutes.courses.Status mapStatus(Status courses) {
        if(courses == Status.FAILURE){
            return com.in28minutes.courses.Status.FAILURE;

        }else
            return com.in28minutes.courses.Status.SUCCESS;

    }
}
