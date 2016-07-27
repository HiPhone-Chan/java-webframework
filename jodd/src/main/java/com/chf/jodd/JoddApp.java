package com.chf.jodd;

import java.io.File;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import org.apache.tomcat.util.descriptor.web.FilterDef;
import org.apache.tomcat.util.descriptor.web.FilterMap;

import jodd.madvoc.MadvocServletFilter;

public class JoddApp {

	public static void main(String[] args) {
		startTomcat();
	}

	private static void startTomcat() {
		try {
			Tomcat tomcat = new Tomcat();
			tomcat.noDefaultWebXmlPath();
			tomcat.setPort(8080);
			String docBase = new File("./www").getAbsolutePath();
			Context ctxt = tomcat.addWebapp("/", docBase);

			FilterDef madvocServletFilter = new FilterDef();
			madvocServletFilter.setFilterName(MadvocServletFilter.class.getSimpleName());
			madvocServletFilter.setFilter(new MadvocServletFilter());
			madvocServletFilter.addInitParameter("madvoc.webapp", "com.chf.jodd.App");
			madvocServletFilter.addInitParameter("madvoc.configurator", "jodd.madvoc.config.RouteMadvocConfigurator");
			madvocServletFilter.addInitParameter("madvoc.params", "/madvoc.props");
			ctxt.addFilterDef(madvocServletFilter);

			FilterMap madvocServletFilterMap = new FilterMap();
			madvocServletFilterMap.setFilterName(MadvocServletFilter.class.getSimpleName());
			madvocServletFilterMap.addURLPattern("/*");
			madvocServletFilterMap.setDispatcher("REQUEST");
			ctxt.addFilterMap(madvocServletFilterMap);

			// Tomcat.addServlet(ctxt, IndexServlet.class.getSimpleName(), new
			// IndexServlet());
			// ctxt.addServletMapping("/", IndexServlet.class.getSimpleName());
			tomcat.start();
			tomcat.getServer().await();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
