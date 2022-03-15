package com.iman.springbootscheduler.config;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class PushGatewayConfiguration {

    @Bean
    MeterRegistryCustomizer<MeterRegistry> metricsCommonTags() {
        return registry -> registry.config().commonTags("application", "spring-boot-task-scheduler");
    }

    @Bean
    public Counter createCourseCounter(MeterRegistry meterRegistry) {
        return Counter.builder("cron.trigger.sum")
                .description("Total number of hit on cron job execution")
                .tag("task-counter", "cloud-scheduler")
                .register(meterRegistry);
    }


//    @Bean
//    public TimedAspect timedAspect(MeterRegistry registry) {
//        return new TimedAspect(registry);
//    }



    @Bean
    public Timer createCoursesTimer(MeterRegistry meterRegistry) {
        return Timer.builder("cron.trigger.timetaken")
                .description("Course creation time taken")
                .register(meterRegistry);
    }

    /*@ConditionalOnProperty(prefix = "push-gateway.credentials", value = "enabled", havingValue = "true")
    @Bean
    @Primary
    public PrometheusPushGatewayManager prometheusPushGatewayManager(CollectorRegistry collectorRegistry,
                                                                     PrometheusProperties prometheusProperties,
                                                                     Environment environment,
                                                                     PushGatewayCredentials credentials) throws MalformedURLException {
        PrometheusProperties.Pushgateway properties = prometheusProperties.getPushgateway();
        Duration pushRate = properties.getPushRate();
        String job = this.getJob(properties, environment);
        Map<String, String> groupingKey = properties.getGroupingKey();
        PrometheusPushGatewayManager.ShutdownOperation shutdownOperation = properties.getShutdownOperation();
        return new PrometheusPushGatewayManager(this.getPushGateway(properties.getBaseUrl(), credentials), collectorRegistry, pushRate, job, groupingKey, shutdownOperation);
    }

    private PushGateway getPushGateway(String url, PushGatewayCredentials credentials) throws MalformedURLException {
        PushGateway pushGateway = new PushGateway(new URL(url));
        pushGateway.setConnectionFactory(new BasicAuthHttpConnectionFactory(credentials.getUsername(), credentials.getPassword()));
        return pushGateway;
    }

    private static String getJob(PrometheusProperties.Pushgateway properties, Environment environment) {
        String job = properties.getJob();
        job = job != null ? job : environment.getProperty("spring.application.name");
        return job != null ? job : "demo-service";
    }*/
}