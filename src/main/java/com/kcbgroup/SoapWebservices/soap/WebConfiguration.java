package com.kcbgroup.SoapWebservices.soap;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.soap.security.xwss.XwsSecurityInterceptor;
import org.springframework.ws.soap.security.xwss.callback.SimplePasswordValidationCallbackHandler;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import java.util.Collections;
import java.util.List;

//use to define the wsdl
//enable web configuration
@EnableWs
//spring configuration
@Configuration
public class WebConfiguration extends WsConfigurerAdapter {
    //message DispatcherServlet which handles request and discover  the end points
     //Application Context
    //url -> /ws/*
    //mapping the dispatcher servlet to the url

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext){
        //mapping instance of message dispatcher servlet to the url,/ws/*
        MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
        messageDispatcherServlet.setApplicationContext(applicationContext);
        messageDispatcherServlet.setTransformSchemaLocations(true);
        return new ServletRegistrationBean(messageDispatcherServlet,"/ws/*");

    }
    //using the course details xsd to generate a wsdl
    //ws/courses.wsdl
    //schema ----course_details.xsd
       //PortType -- course port
       //Namespace ---http.//in28minutes.com/courses
    @Bean(name = "courses")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema coursesSchema){


        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();

        //PortType -- course port
        definition.setPortTypeName("CoursePort");
        //Namespace ---http.//in28minutes.com/courses
        definition.setTargetNamespace("http.//in28minutes.com/courses");
        //ws
        definition.setLocationUri("http://localhost:8080/ws/courses.wsdl");

        //schema

        definition.setSchema(coursesSchema);
        return definition;
    }

    @Bean
    public XsdSchema coursesSchema(){

        return new SimpleXsdSchema(new ClassPathResource("course_details.xsd"));
    }
//creating a xws interceptor
    @Bean
    public XwsSecurityInterceptor securityInterceptor(){
        XwsSecurityInterceptor securityInterceptor = new XwsSecurityInterceptor();
//adding the callBack Handler
        securityInterceptor.setCallbackHandler(callBackHandler());
        //security config
        securityInterceptor.setPolicyConfiguration(new ClassPathResource("securityPolicy.xml"));



        return securityInterceptor;
    }

    private SimplePasswordValidationCallbackHandler callBackHandler() {
        SimplePasswordValidationCallbackHandler handler= new SimplePasswordValidationCallbackHandler();
        //password and username config
        handler.setUsersMap(Collections.singletonMap("user","password"));
        return handler;
    }

    //adding interceptor to the group of interceptors
    @Override
    public void addInterceptors(List<EndpointInterceptor> interceptors) {
        interceptors.add(securityInterceptor());
    }
    //xws Security Interceptor
    // interceptor--intercept all request to ensure that they are secure
    //Callback Handler ---check password and username;SimplePasswordValidationCallBackHandler;
    //Security policy-- securityPolicy.xml and configure in the interceptor

    //XWSSecurity interceptor to be added to the list of interceptor provided by the spring ws


}


