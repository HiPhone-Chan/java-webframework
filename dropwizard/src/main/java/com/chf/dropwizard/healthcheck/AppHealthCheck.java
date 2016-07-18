package com.chf.dropwizard.healthcheck;

import com.codahale.metrics.health.HealthCheck;

public class AppHealthCheck extends HealthCheck {

    private final String appName;

    public AppHealthCheck(String appName) {
        this.appName = appName;
    }

    @Override
    protected Result check() throws Exception {
        if (!"app".equalsIgnoreCase(appName)) {
            return Result.unhealthy("App name not match.");
        }
        return Result.healthy();
    }

}
