package com.chf.dropwizard;

import org.apache.commons.lang3.ArrayUtils;
import org.hibernate.SessionFactory;

import com.chf.dropwizard.config.AppConfig;
import com.chf.dropwizard.db.DbUtil;
import com.chf.dropwizard.domain.Resource;
import com.chf.dropwizard.healthcheck.AppHealthCheck;
import com.chf.dropwizard.service.AppTask;
import com.chf.dropwizard.service.ResourceService;
import com.chf.dropwizard.web.rest.HelloResource;
import com.chf.dropwizard.web.rest.IndexResource;

import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.jersey.setup.JerseyEnvironment;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class DropwizardApp extends Application<AppConfig> {

	private HibernateBundle<AppConfig> hibernateBundle;

	public static void main(String[] args) throws Exception {
		if (ArrayUtils.isEmpty(args)) {
			args = new String[] { "server", "app.yml" };
		}
		new DropwizardApp().run(args);
	}

	@Override
	public void run(AppConfig config, Environment env) throws Exception {
		env.healthChecks().register("app", new AppHealthCheck(getName()));

		SessionFactory sessionFactory = hibernateBundle.getSessionFactory();
		DbUtil.setSessionFactory(sessionFactory);

		initResource(env.jersey());
		env.admin().addTask(new AppTask("out"));
	}

	@Override
	public void initialize(Bootstrap<AppConfig> bootstrap) {
		hibernateBundle = initHibernateBundle();
		bootstrap.addBundle(hibernateBundle);
		super.initialize(bootstrap);
	}

	private void initResource(JerseyEnvironment env) {
		// SpringUtil.getBeansWithAnnotation(Path.class).forEach((k, v) -> {
		// });
		env.packages("com.chf.dropwizard");
		env.register(ResourceService.class);
		env.register(HelloResource.class);
		env.register(IndexResource.class);
	}

	private HibernateBundle<AppConfig> initHibernateBundle() {
		HibernateBundle<AppConfig> bundle = new HibernateBundle<AppConfig>(Resource.class) {

			public DataSourceFactory getDataSourceFactory(AppConfig configuration) {
				return configuration.getDataSourceFactory();
			}
		};
		return bundle;
	}

}
