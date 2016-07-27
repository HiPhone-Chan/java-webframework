package com.chf.vertx.web.rest;

import com.chf.core.domain.Resp;

import io.vertx.core.json.Json;
import io.vertx.ext.web.Router;

public class HelloResource {

	public static Router renderRouter(Router router) {
		router.get("/hello").handler(context -> {
			String name = context.request().getParam("name");
			context.response().end(Json.encode(new Resp(name)));
		});
		return router;
	}
}
