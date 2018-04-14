package com.kun.neo4j.spring.context;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class MyWebServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { Application.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { Application.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    @Override
    protected Filter[] getServletFilters() {
        return new Filter[] { };
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // initialize before servlet startup
        //servletContext.setInitParameter("springs.profiles.active", "dev");
        super.onStartup(servletContext);
    }
}
