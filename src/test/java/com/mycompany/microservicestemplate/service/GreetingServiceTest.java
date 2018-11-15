package com.mycompany.microservicestemplate.service;

import com.mycompany.microservicestemplate.model.Greeting;
import com.mycompany.microservicestemplate.repository.GreetingsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class GreetingServiceTest {

    @Mock
    private GreetingsRepository greetingsRepository;

    @InjectMocks
    private GreetingService greetingService;

    @Test(expected = IllegalArgumentException.class)
    public void getGreetingWithEmptyNameShouldThrowException(){
        greetingService.getGreeting("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void getGreetingWithNullNameShouldThrowException(){
        greetingService.getGreeting(null);
    }

    @Test
    public void getGreetingWithNameShouldReturnNewGreetings() {
        Greeting greetingFromDb = new Greeting("Ciao, ", "Greetings message");

        Mockito.when(greetingsRepository.findOne()).thenReturn(greetingFromDb);

        Greeting actual = greetingService.getGreeting("Colin");

        assertEquals("Ciao, Colin", actual.getGreet());
        assertEquals("Greetings message", actual.getMessage());
    }

}
