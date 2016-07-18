package com.chf.spark;

import static spark.Spark.get;
import static spark.Spark.port;
import com.chf.spark.web.rest.HelloResource;

public class Main {

    public static void main(String[] args) {
        port(9090);
        get("/", (req, res) -> "Welcome");
        HelloResource.init();
    }

}
