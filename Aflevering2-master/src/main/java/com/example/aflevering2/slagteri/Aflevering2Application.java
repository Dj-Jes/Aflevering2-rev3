package com.example.aflevering2.slagteri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.server.core.EvoInflectorLinkRelationProvider;
import server.HelloServer;
import server.HelloServiceImpl;


@SpringBootApplication

public class Aflevering2Application {

    public static void main (String[] args) {
        SpringApplication.run(HelloServer.class, args);
        // port9000 sat i application.properties
        //http://localhost:9000
        //Mit navn er Sten
        //Med det KÆMPE ben
        // - Jesper
        // michael er gammel altså, sådan riiiiigtig gammel
        // - Mikkel
    }


}
