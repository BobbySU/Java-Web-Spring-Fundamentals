package com.example.Introduction.testBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration
public class BeanConfiguration {

    @Bean
    public Animal dog(){
        return new Dog();
    }

//    @Primary
    @Bean
//    @Scope("prototype")
    public Animal cat(){
        return new Cat();
    }
}
