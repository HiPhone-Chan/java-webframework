package com.chf.spark.web.rest;

import static com.chf.spark.util.JsonUtil.GSON;
import static spark.Spark.get;

import com.chf.core.domain.Resp;

public class HelloResource {

	public static void init() {
		get("/hello", (req, res) -> {
			String name = req.queryParams("name");
			return new Resp(name);
		}, GSON::toJson);
	}
}
