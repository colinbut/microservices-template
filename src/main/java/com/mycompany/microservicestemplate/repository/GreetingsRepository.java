/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.microservicestemplate.repository;

import com.mycompany.microservicestemplate.model.Greeting;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
@Repository
public class GreetingsRepository {

    private List<Greeting> greetings = new ArrayList<>();

    @PostConstruct
    public void init() {
        LOGGER.info("Setting up greetings");

        greetings.add(new Greeting("Hello, ", ""));
        greetings.add(new Greeting("Welcome, ", ""));
        greetings.add(new Greeting("Li Hao, ", ""));
        greetings.add(new Greeting("Weikomen, ", ""));
        greetings.add(new Greeting("Bonjour, ", ""));
        greetings.add(new Greeting("Hola, ", ""));

        LOGGER.info("Populated greetings {}", greetings);
    }

    public Greeting findOne(){
        return greetings.get(new Random().nextInt(greetings.size() -1));
    }
}
