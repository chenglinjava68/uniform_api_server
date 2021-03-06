package com.dos.bsapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.context.web.SpringBootServletInitializer;

//import com.dos.bsapp.conf.ShiroFilterProperties;

//@EnableConfigurationProperties({ShiroFilterProperties.class})
@SpringBootApplication
public class ApplicationWar extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ApplicationWar.class);
    }

    public static void main(String[] args) {
        org.apache.ibatis.logging.LogFactory.useSlf4jLogging();
		org.apache.ibatis.logging.LogFactory.useLog4JLogging();
		org.apache.ibatis.logging.LogFactory.useJdkLogging();
		org.apache.ibatis.logging.LogFactory.useCommonsLogging();
		org.apache.ibatis.logging.LogFactory.useStdOutLogging();

        SpringApplication.run(ApplicationWar.class, args);
        /*
        ApplicationContext ctx =  SpringApplication.run(ApplicationWar.class, args);
       String[] activeProfiles = ctx.getEnvironment().getActiveProfiles();
        for (String profile : activeProfiles) {
            //logger.warn("Spring Boot 使用profile为:{}" , profile);
        }*/
    }
}
