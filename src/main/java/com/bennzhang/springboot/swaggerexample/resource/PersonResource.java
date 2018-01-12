package com.bennzhang.springboot.swaggerexample.resource;

import com.bennzhang.springboot.swaggerexample.domain.Person;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/rest/person")
@Api(value = "person", description = "Shows the user info")
public class PersonResource {

    @GetMapping
    public List<Person> getPersons() {

        return Arrays.asList(
                new Person("Sam", "agent" , 2000L),
                new Person("Peter", "supervisor", 1000L)
        );
    }

    @GetMapping("/{userName}")
    public Person getPerson(@PathVariable("userName") final String userName)
    {
        return new Person(userName, "agent", 1000L);
    }
}
