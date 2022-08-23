package com.company;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigCar {

    //wiring
//    @Bean
//    Person person(){
//        Person person =new Person();
//        person.setName("Mike");
//        person.setCar(car());
//        return person;
//    }

    //Autowiring
    @Bean
    Person person(Car car){
        Person person =new Person();
        person.setName("Mike");
        person.setCar(car);
        return person;
    }

    @Bean
    Car car(){
        Car car =new Car();
        car.setMake("Subaru");
        return car;
    }
}
