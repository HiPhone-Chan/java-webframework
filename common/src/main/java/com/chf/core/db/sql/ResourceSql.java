package com.chf.core.db.sql;

public class ResourceSql {

	public static final String SQL_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS `resource` (`id` BIGINT(20) NOT NULL,`code` VARCHAR(255) NULL DEFAULT NULL,`name` VARCHAR(255) NULL DEFAULT NULL,`type` VARCHAR(255) NULL DEFAULT NULL,PRIMARY KEY (`id`))";

}
