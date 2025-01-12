package com.dktechno.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev") // All the configuration in dev environment
public class ApplicationConfig {

    @Bean
    @Qualifier("bean1")
    //@Profile("dev") // Just this bean in dev environment
    public MyFirstClass myFirstBean() {
        return new MyFirstClass("First bean");
    }

    @Bean
    //@Profile("test")
    //@Qualifier("bean2")
    public MyFirstClass mySecondBean() {
        return new MyFirstClass("Second bean");
    }

    @Bean
    @Primary
    //@Qualifier("bean2")
    public MyFirstClass myThirdBean() {
        return new MyFirstClass("Third bean");
    }
}
