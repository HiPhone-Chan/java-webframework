package com.chf.jodd.web.rest;

import com.chf.core.domain.Resp;

import jodd.madvoc.meta.In;
import jodd.madvoc.meta.MadvocAction;
import jodd.madvoc.meta.RestAction;

@MadvocAction
public class HelloResource {

	@RestAction(value = "/hello", method = "GET")
	public Resp sayHello(@In String name) {
		return new Resp(name);
	}

}
