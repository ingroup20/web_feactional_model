package com.t1.demo_web_springboot.monitor.config;

import io.micrometer.core.instrument.MeterRegistry;

import org.springframework.stereotype.Component;

@Component
public class CustomMetricsService {

//    private final Counter customMetricCounter;

//    public CustomMetricsService(MeterRegistry meterRegistry) {
//        customMetricCounter = Counter.builder("prometheus_model")
//                .description("Description of custom metric")
//                .tags("environment", "development")
//                .register(meterRegistry);
//    }
//
//    public void incrementCustomMetric() {
//        customMetricCounter.increment();
//    }
}
