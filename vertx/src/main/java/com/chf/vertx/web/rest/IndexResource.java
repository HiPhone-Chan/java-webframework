package com.chf.vertx.web.rest;

import io.vertx.ext.web.Router;

public class IndexResource {

	public static Router renderRouter(Router router) {
		router.get("/").handler(context -> {
			context.response().end("Welcome to Vert.x.");
		});
		return router;
	}
}
