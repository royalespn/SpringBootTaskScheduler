package com.iman.springbootscheduler.task;

import io.micrometer.core.instrument.Counter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
@Slf4j
public class ScheduledTasks {

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    @Autowired
    public Counter hitCounter;


//    @Timed(value = "scheduleTaskWithCronExpression-procss", description = "Time spent processing method execution",
//            extraTags = {"type", "scheduleTaskWithCronExpression"})
    @Scheduled(cron = "*/4 * * * * *")
    public void scheduleTaskWithCronExpression() {
        hitCounter.increment();
        log.info("Current Thread : {}", Thread.currentThread().getName());
        log.info("Cron Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));

    }

}
