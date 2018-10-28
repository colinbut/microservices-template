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

        greetings.add(new Greeting("Hello, ", "Stay in bed and dream or get out and chase them!"));
        greetings.add(new Greeting("Welcome, ", "The sky’s the limit, only if you believe it is"));
        greetings.add(new Greeting("Li Hao, ", "Begin this day with a smile on your face"));
        greetings.add(new Greeting("Weikomen, ", "Mornings are too beautiful for regrets"));
        greetings.add(new Greeting("Bonjour, ", "Wish all your friends good morning!"));
        greetings.add(new Greeting("Hola, ", "Think of all the people who make you happy!"));

        LOGGER.info("Populated greetings {}", greetings);
    }

    public Greeting findOne(){
        return greetings.get(new Random().nextInt(greetings.size() -1));
    }
}
