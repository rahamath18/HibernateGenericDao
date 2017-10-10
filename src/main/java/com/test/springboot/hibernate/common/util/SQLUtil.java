package com.test.springboot.hibernate.common.util;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.TypeMismatchException;

public class SQLUtil {
	
	public static void setParameters(SQLQuery query, List parameters) {

		for (int i = 0; i < parameters.size(); i++) {

			Object parameter = parameters.get(i);
			// System.err.println("i = " + i + ", "+
			// parameter.getClass().getName() + ", value="+ parameter);
			try {
				if (parameter instanceof String) {
					query.setString(i, (String) parameter);
					continue;
				}
				if (parameter instanceof Long) {
					query.setLong(i, (Long) parameter);
					continue;
				}
				if (parameter instanceof Integer) {
					query.setInteger(i, (Integer) parameter);
					continue;
				}
				if (parameter instanceof Boolean) {
					query.setBoolean(i, (Boolean) parameter);
					continue;
				}
				if (parameter instanceof Timestamp) {
					query.setTimestamp(i, (Timestamp) parameter);
					continue;
				}
				if (parameter instanceof Date) {
					query.setDate(i, (Date) parameter);
					continue;
				}
				throw new TypeMismatchException(
						String.format("Type not supported: %s", parameter.getClass().getSimpleName()));
			} catch (Exception ex) {
				// ex.printStackTrace();
				String msg = String.format(
						"setParameters: Error when setting parameter # %d: Type '%s', Value '%s', Exception: %s, Query: %s",
						i, parameter.getClass().getSimpleName(), parameter, ex.getMessage(), query.getQueryString());
				throw new RuntimeException(msg);
			}
		}
	}

}
