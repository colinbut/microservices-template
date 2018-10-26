/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.microservicestemplate.web;

import com.mycompany.microservicestemplate.model.Greeting;
import com.mycompany.microservicestemplate.service.GreetingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("microservices-template/v1/api/")
public class GreetingsController {

    @Autowired
    private GreetingService greetingService;

    @GetMapping("/greet/{name}")
    public ResponseEntity<Greeting> greet(@PathVariable String name) {
        LOGGER.info("Getting greetings for {}", name);
        return ResponseEntity.ok(greetingService.getGreeting(name));
    }
}
