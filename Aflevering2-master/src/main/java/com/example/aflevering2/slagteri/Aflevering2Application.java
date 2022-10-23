package com.example.aflevering2.slagteri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.server.core.EvoInflectorLinkRelationProvider;


@SpringBootApplication

public class Aflevering2Application {

    public static void main (String[] args) {
        SpringApplication.run(Aflevering2Application.class, args);
        // port9000 sat i application.properties
        //http://localhost:9000
    }


}
