package com.godeltech.app.controller.mapper.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author Dmitry Chueshov 06.12.2020 15:10
 *
 */

@Configuration
public class MapConfig {
    
    @Bean
    public ModelMapper mapper() {
        return new ModelMapper();
    }
    
    
}
