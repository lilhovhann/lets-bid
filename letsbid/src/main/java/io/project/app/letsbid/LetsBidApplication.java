package io.project.app.letsbid;

import io.project.app.letsbid.domain.response.BidResponse;
import io.project.app.letsbid.repositories.BidResponseRepository;
import io.project.app.letsbid.utils.BidGenerator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.EventListener;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableMongoRepositories("io.project.app.letsbid.repositories")
@ComponentScan("io.project")
@EntityScan("io.project.app.letsbid.domain.*")
@EnableAsync
@Slf4j
public class LetsBidApplication{

    @Autowired
    private BidResponseRepository bidResponseRepo;

    @Autowired
    private BidGenerator bidGenerator;


    public static void main(String[] args) {
        SpringApplication.run(LetsBidApplication.class, args);
    }

    

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
