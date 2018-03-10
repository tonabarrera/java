package com.tona.backendninja.service.impl;

import com.tona.backendninja.model.Person;
import com.tona.backendninja.service.ExampleService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tona created on 10/03/2018 for backendninja.
 */
@Service("exampleService")
public class ExampleServiceImpl implements ExampleService {
    private static final Log LOG = LogFactory.getLog(ExampleService.class);
    @Override
    public List<Person> getListPeople() {
        List<Person> people = new ArrayList<>();
        people.add(new Person("General Kenobi", 30));
        people.add(new Person("Griveous", 10));
        people.add(new Person("Anakin", 20));
        people.add(new Person("Palpatine", 80));
        people.add(new Person("R2D2", 2));
        LOG.info("HELLO FROM THE FIRST SERVICE");
        return people;

    }
}
