package com.wch.account.mapper;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author c
 * @date 2021/4/3
 */
@Configuration
public class ModelMapperFactory {
    @Bean
    ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
