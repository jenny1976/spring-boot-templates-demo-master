package com.miko.springboot;

import com.mitchellbosecke.pebble.PebbleEngine;
import com.mitchellbosecke.pebble.loader.Loader;
import com.mitchellbosecke.pebble.loader.ServletLoader;
import com.mitchellbosecke.pebble.spring4.PebbleViewResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import javax.servlet.ServletContext;
import java.util.Arrays;
import java.util.List;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

@Configuration
@EnableWebMvc
public class MvcConfiguration implements WebMvcConfigurer {

    @Autowired
    private ServletContext servletContext;

    @Bean(name = "viewResolver")
    public ViewResolver contentNegotiatingViewResolver( ContentNegotiationManager manager) {
        List<ViewResolver> resolvers =
                Arrays.asList(
                        freeMarkerViewResolver(),
//                        getPebbleViewResolver(),
                        thymeleafViewResolver()
                );
        ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
        resolver.setViewResolvers(resolvers);
        resolver.setContentNegotiationManager(manager);
        return resolver;
    }

    /* freemarker */
    @Bean
    public FreeMarkerConfigurer freeMarkerConfigurer() {
        FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
        freeMarkerConfigurer.setTemplateLoaderPath("/WEB-INF/templates/freemarker/");
    return freeMarkerConfigurer;
}

    @Bean
    public FreeMarkerViewResolver freeMarkerViewResolver() {
        FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
        resolver.setPrefix("/WEB-INF/templates/freemarker/");
        resolver.setSuffix(".ftl");
        resolver.setCache(false);
        resolver.setCacheUnresolved(false);
        resolver.setOrder(1);
        return resolver;
    }

    /* pebble */
    @Bean(name="pebbleViewResolver")
    public ViewResolver getPebbleViewResolver(){
        PebbleViewResolver resolver = new PebbleViewResolver();
        resolver.setPrefix("/WEB-INF/templates/pebble/");
        resolver.setSuffix(".html");
        resolver.setPebbleEngine(pebbleEngine());
        resolver.setCache(false);
        resolver.setCacheUnresolved(false);
        resolver.setOrder(2);
        return resolver;
    }

    @Bean
    public Loader templatePebbleLoader(){
        return new ServletLoader(servletContext);
    }

    @Bean
    public PebbleEngine pebbleEngine() {
        return new PebbleEngine.Builder()
                .loader(templatePebbleLoader())
                .build();
    }

    /* thymeleaf */
    @Bean
    public ThymeleafViewResolver thymeleafViewResolver() {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(thymeleafTemplateEngine());
        resolver.setCache(false);
        resolver.setCacheUnresolved(false);
        resolver.setOrder(0);
        return resolver;
    }

    @Bean
    public SpringTemplateEngine thymeleafTemplateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(thymeleafTemplateResolver());
        return templateEngine;
    }

    @Bean
    public SpringResourceTemplateResolver thymeleafTemplateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setPrefix("/WEB-INF/templates/thymeleaf/");
        templateResolver.setSuffix(".htm");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        return templateResolver;
    }









    @Bean
    public ViewResolver jspViewResolver() {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setPrefix("/WEB-INF/jsp/");
        bean.setSuffix(".jsp");
        bean.setOrder(4);
        return bean;
    }
}
