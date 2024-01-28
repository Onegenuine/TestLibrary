package ru.falaleev.tesproject.TestLibrary;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@SpringBootApplication
public class TestLibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestLibraryApplication.class, args);


    }
    //внедрили бин ModelMapper
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

}
