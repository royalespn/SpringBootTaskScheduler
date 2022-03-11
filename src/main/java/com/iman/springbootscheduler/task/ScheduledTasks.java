package com.iman.springbootscheduler.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
@Slf4j
public class ScheduledTasks {

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    @Scheduled(cron = "*/4 * * * * *")
    public void scheduleTaskWithCronExpression() {

        log.info("Current Thread : {}", Thread.currentThread().getName());
        log.info("Cron Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));

     System.out.println("Cron Task :: Execution Time - {}" );
    }
}
