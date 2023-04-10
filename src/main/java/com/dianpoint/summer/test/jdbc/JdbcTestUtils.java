//package com.dianpoint.summer.test.jdbc;
//
//
//public abstract class JdbcTestUtils {
//
//
//	public static int countRowsInTable(JdbcTemplate jdbcTemplate, String tableName) {
//		Integer result = jdbcTemplate.queryForObject("SELECT COUNT(0) FROM " + tableName, Integer.class);
//		return (result != null ? result : 0);
//	}
//
//	public static int countRowsInTableWhere(JdbcTemplate jdbcTemplate, String tableName, String whereClause) {
//		String sql = "SELECT COUNT(0) FROM " + tableName;
//		if (StringUtils.hasText(whereClause)) {
//			sql += " WHERE " + whereClause;
//		}
//		Integer result = jdbcTemplate.queryForObject(sql, Integer.class);
//		return (result != null ? result : 0);
//	}
//
//	public static int deleteFromTables(JdbcTemplate jdbcTemplate, String... tableNames) {
//		int totalRowCount = 0;
//		for (String tableName : tableNames) {
//			int rowCount = jdbcTemplate.update("DELETE FROM " + tableName);
//			totalRowCount += rowCount;
//			if (logger.isInfoEnabled()) {
//				logger.info("Deleted " + rowCount + " rows from table " + tableName);
//			}
//		}
//		return totalRowCount;
//	}
//
//	public static int deleteFromTableWhere(
//			JdbcTemplate jdbcTemplate, String tableName, String whereClause, Object... args) {
//
//		String sql = "DELETE FROM " + tableName;
//		if (StringUtils.hasText(whereClause)) {
//			sql += " WHERE " + whereClause;
//		}
//		int rowCount = (args.length > 0 ? jdbcTemplate.update(sql, args) : jdbcTemplate.update(sql));
//		if (logger.isInfoEnabled()) {
//			logger.info("Deleted " + rowCount + " rows from table " + tableName);
//		}
//		return rowCount;
//	}
//
//	public static void dropTables(JdbcTemplate jdbcTemplate, String... tableNames) {
//		for (String tableName : tableNames) {
//			jdbcTemplate.execute("DROP TABLE " + tableName);
//			if (logger.isInfoEnabled()) {
//				logger.info("Dropped table " + tableName);
//			}
//		}
//	}
//
//}
