package com.chf.dropwizard.web.rest;

import javax.annotation.ManagedBean;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import com.chf.core.domain.Resp;
import com.chf.dropwizard.service.ResourceService;
import com.codahale.metrics.annotation.Timed;

@Path("/app")
@Produces(MediaType.APPLICATION_JSON)
@ManagedBean
public class HelloResource {

	@Context
	private ResourceService resourceService;

	@Context
	private UriInfo uriInfo;

	@GET
	@Timed
	public Resp sayHello(@QueryParam("name") String name) {
		return new Resp(name);
	}

	@GET
	@Path("/r")
	@Timed
	public String resource() {
		return resourceService.findAll();
	}
}
