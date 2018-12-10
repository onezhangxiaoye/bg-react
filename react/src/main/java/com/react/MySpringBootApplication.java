package com.react;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * name
 *
 * @author yuehaiming
 * @version 1.0.0.0
 * @date 1 1
 */
@SpringBootApplication
@MapperScan("cn.react.pojo")
public class MySpringBootApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MySpringBootApplication.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(MySpringBootApplication.class, args);
    }

}

