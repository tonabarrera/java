package com.tona.backendninja.component;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author tona created on 17/03/2018 for backendninja.
 */
@Component("taskComponent")
public class TaskComponent {
    private static final Log LOG = LogFactory.getLog(TaskComponent.class);

    @Scheduled(fixedDelay = 5000)
    public void doTask() {
        LOG.info("Time is: " + new Date());
    }
}
