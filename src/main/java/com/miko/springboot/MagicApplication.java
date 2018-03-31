package com.miko.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author Miro Kopecky (@miragemiko)
 * @since 06.11.2016
 */

@SpringBootApplication
public class MagicApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(MagicApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
        return application.sources(MagicApplication.class);
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
    }
}
