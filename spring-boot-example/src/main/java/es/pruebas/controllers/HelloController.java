package es.pruebas.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.pruebas.domain.web.Greeting;

@RestController
public class HelloController {
	private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
    @RequestMapping("/greeting/{name}")
    public Greeting greeting(@PathVariable(value="name", required=true) String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
}
