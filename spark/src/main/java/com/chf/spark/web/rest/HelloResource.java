package com.chf.spark.web.rest;

import static spark.Spark.get;

public class HelloResource {

    public static void init() {
        get("/hello", (req, res) -> "Hello World");
    }
}
