package com.chf.spark.db;

import org.sql2o.Connection;
import org.sql2o.Sql2o;

import com.chf.core.db.sql.ResourceSql;

public enum DbUtil {

	INSTANCE;

	private Sql2o sql2o;

	private DbUtil() {
		String url = "jdbc:mysql:///test?useUnicode=true&characterEncoding=utf8";
		String username = "root";
		String password = null;
		sql2o = new Sql2o(url, username, password);
	}

	public Sql2o getSql2oInstance() {
		return sql2o;
	}

	public void createTable() {
		try (Connection con = getSql2oInstance().open()) {
			con.createQuery(ResourceSql.SQL_CREATE_TABLE).executeUpdate();
		}
	}
}
