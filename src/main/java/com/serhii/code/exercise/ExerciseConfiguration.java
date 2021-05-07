package com.serhii.code.exercise;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;




@Configuration
@ComponentScan("com.serhii.code.exercise")
public class ExerciseConfiguration {



    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
                .info(
                        new Info()
                        .title("Exercise")
                        .version("1.0.0")
                        .contact(
                                new Contact()
                                .name("Serhii Tereshchenko")));
    }
}
