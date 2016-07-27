package com.chf.spark;

import static spark.Spark.port;

import com.chf.spark.db.DbUtil;
import com.chf.spark.web.rest.HelloResource;
import com.chf.spark.web.rest.IndexResource;

public class SparkApp {

	public static void main(String[] args) {
		DbUtil.INSTANCE.createTable();
		port(9090);
		IndexResource.init();
		HelloResource.init();
	}

}
