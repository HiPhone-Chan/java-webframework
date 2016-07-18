package com.chf.dropwizard;

import javax.ws.rs.Path;

import org.springframework.context.annotation.ComponentScan;

import com.chf.dropwizard.config.AppConfig;
import com.chf.dropwizard.domain.Resource;
import com.chf.dropwizard.healthcheck.AppHealthCheck;
import com.chf.dropwizard.service.AppTask;
import com.chf.dropwizard.util.SpringUtil;

import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.jersey.setup.JerseyEnvironment;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

@ComponentScan
public class App extends Application<AppConfig> {

    public static void main(String[] args) throws Exception {
        new App().run(args);
    }

    @Override
    public void run(AppConfig config, Environment env) throws Exception {
        env.healthChecks().register("app", new AppHealthCheck(getName()));

        initResource(env.jersey());
        env.admin().addTask(new AppTask("out"));
    }

    @Override
    public void initialize(Bootstrap<AppConfig> bootstrap) {

        bootstrap.addBundle(new HibernateBundle<AppConfig>(Resource.class) {

            public DataSourceFactory getDataSourceFactory(
                    AppConfig configuration) {
                return configuration.getDataSourceFactory();
            }
        });
        super.initialize(bootstrap);
    }

    private void initResource(JerseyEnvironment env) {

        SpringUtil.getBeansWithAnnotation(Path.class).forEach((k, v) -> {
            env.register(v);
        });
    }

}
