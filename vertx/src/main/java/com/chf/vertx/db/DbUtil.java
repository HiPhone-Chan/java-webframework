package com.chf.vertx.db;

import com.chf.core.db.sql.ResourceSql;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.jdbc.JDBCClient;
import io.vertx.ext.sql.ResultSet;
import io.vertx.ext.sql.SQLConnection;
import io.vertx.ext.sql.UpdateResult;

public class DbUtil {

	private JDBCClient client;

	private SQLConnection conn;

	public DbUtil(Vertx vertx) {
		JsonObject config = new JsonObject().put("url", "jdbc:mysql:///test?useUnicode=true&characterEncoding=utf8")
				.put("driver_class", "com.mysql.jdbc.Driver");
		client = JDBCClient.createShared(vertx, config);

		client.getConnection(resp -> {
			if (resp.succeeded()) {
				conn = resp.result();
				createTable(conn);
			}
		});

	}

	public void createTable(SQLConnection conn) {
		conn.execute(ResourceSql.SQL_CREATE_TABLE, result -> {
			if (result.failed()) {
				System.out.println("create fail - " + result.cause());
			}
		});
	}

	public void query(String queryString, Handler<AsyncResult<ResultSet>> resultHandler) {
		conn.query(queryString, resultHandler);
	}

	public void queryWithParams(String queryString, JsonArray array, Handler<AsyncResult<ResultSet>> resultHandler) {
		conn.queryWithParams(queryString, array, resultHandler);
	}

	/**
	 * insert / update
	 * 
	 * @param updateString
	 */
	public void update(String updateString, Handler<AsyncResult<UpdateResult>> resultHandler) {
		conn.update(updateString, resultHandler);
	}
}
