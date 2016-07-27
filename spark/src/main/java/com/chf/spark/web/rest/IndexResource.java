package com.chf.spark.web.rest;

import static spark.Spark.get;

public class IndexResource {

	public static void init() {
		get("/", (req, res) -> "Welcome to Spark.");
	}
}
