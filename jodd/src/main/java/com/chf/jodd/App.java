package com.chf.jodd;

import javax.servlet.ServletContext;

import com.chf.jodd.web.rest.IndexResource;

import jodd.madvoc.WebApplication;
import jodd.madvoc.component.MadvocConfig;

public class App extends WebApplication {

	@Override
	protected void initWebApplication() {
		super.initWebApplication();
	}

	@Override
	protected void init(MadvocConfig madvocConfig, ServletContext servletContext) {
		madvocConfig.getRootPackages().addRootPackageOf(IndexResource.class);
		super.init(madvocConfig, servletContext);
	}
}
