/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.microservicestemplate.service;

import com.mycompany.microservicestemplate.model.Greeting;
import com.mycompany.microservicestemplate.repository.GreetingsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Slf4j
@Service
public class GreetingService {

    private static final String GREETING_LINE_FORMAT = "%s%s";

    @Autowired
    private GreetingsRepository greetingsRepository;

    public Greeting getGreeting(String name) {

        if (StringUtils.isEmpty(name)) {
            throw new IllegalArgumentException("Name cannot be empty or null");
        }

        Greeting greeting = greetingsRepository.findOne();

        LOGGER.info("Fetched greeting {} from storage", greeting);

        // defensive copy to prevent source model objetc from being mutated
        return new Greeting(String.format(GREETING_LINE_FORMAT, greeting.getGreet() , name), greeting.getMessage());
    }
}
