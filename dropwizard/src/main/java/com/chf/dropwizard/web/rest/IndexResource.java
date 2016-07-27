package com.chf.dropwizard.web.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.codahale.metrics.annotation.Timed;

@Path("/")
public class IndexResource {

	@GET
	@Timed
	public String welcome() {
		return "Welcome to Dropwizard.";
	}
}
