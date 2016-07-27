package com.chf.vertx;

import com.chf.vertx.db.DbUtil;
import com.chf.vertx.web.rest.HelloResource;
import com.chf.vertx.web.rest.IndexResource;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.web.Router;

public class VertxApp {

	public static final Logger logger = LoggerFactory.getLogger(VertxApp.class);

	public static final int PORT = 8080;

	public static void main(String[] args) {
		Vertx vertx = Vertx.vertx();
		Router router = Router.router(vertx);

		DbUtil dbUtil = new DbUtil(vertx);

		IndexResource.renderRouter(router);
		HelloResource.renderRouter(router);

		HttpServer server = vertx.createHttpServer();
		server.requestHandler(router::accept);
		server.listen(PORT, res -> {
			if (res.succeeded()) {
				logger.info(String.format("Listening port: %d.", PORT));
			}
		});
	}

}
