package com.chf.jodd.web.rest;

import jodd.madvoc.meta.MadvocAction;
import jodd.madvoc.meta.RestAction;

@MadvocAction
public class IndexResource {

	@RestAction(method = "GET")
	public String index() {
		return "index";
	}

}
