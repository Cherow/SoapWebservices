//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.08.02 at 11:28:58 AM EAT 
//


package com.in28minutes.courses;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.in28minutes.courses package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.in28minutes.courses
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetCourseDetailsRequest }
     * 
     */
    public GetCourseDetailsRequest createGetCourseDetailsRequest() {
        return new GetCourseDetailsRequest();
    }

    /**
     * Create an instance of {@link DeleteCourseDetailsRequest }
     * 
     */
    public DeleteCourseDetailsRequest createDeleteCourseDetailsRequest() {
        return new DeleteCourseDetailsRequest();
    }

    /**
     * Create an instance of {@link GetCourseDetailsResponse }
     * 
     */
    public GetCourseDetailsResponse createGetCourseDetailsResponse() {
        return new GetCourseDetailsResponse();
    }

    /**
     * Create an instance of {@link CourseDetails }
     * 
     */
    public CourseDetails createCourseDetails() {
        return new CourseDetails();
    }

    /**
     * Create an instance of {@link DeleteCourseDetailsResponse }
     * 
     */
    public DeleteCourseDetailsResponse createDeleteCourseDetailsResponse() {
        return new DeleteCourseDetailsResponse();
    }

    /**
     * Create an instance of {@link GetALLCourseDetailsRequest }
     * 
     */
    public GetALLCourseDetailsRequest createGetALLCourseDetailsRequest() {
        return new GetALLCourseDetailsRequest();
    }

    /**
     * Create an instance of {@link GetALLCourseDetailsResponse }
     * 
     */
    public GetALLCourseDetailsResponse createGetALLCourseDetailsResponse() {
        return new GetALLCourseDetailsResponse();
    }

}
