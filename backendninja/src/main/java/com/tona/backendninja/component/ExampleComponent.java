package com.tona.backendninja.component;

import com.tona.backendninja.repository.CourseJPARepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author tona created on 10/03/2018 for backendninja.
 */
@Component("exampleComponent")
public class ExampleComponent {
    private static final Log LOGGER = LogFactory.getLog(ExampleComponent.class);
    @Autowired
    @Qualifier("courseJPARepository")
    private CourseJPARepository courseJPARepository;

    public ExampleComponent() {}
    public  void sayHello() {

        LOGGER.info("HELLO FROM A COMPONENT");

    }
}
