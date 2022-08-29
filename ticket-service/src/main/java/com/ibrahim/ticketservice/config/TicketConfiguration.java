package com.ibrahim.ticketservice.config;

import com.ibrahim.ticketservice.repository.TicketRepository;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.ibrahim")
@EnableElasticsearchRepositories("com.ibrahim.ticketservice.repository.es")
@ComponentScan("com.ibrahim")
public class TicketConfiguration {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
