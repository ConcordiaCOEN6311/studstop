package com.concordia.dao;

import com.concordia.utils.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author: Wei Qi
 * @Package: com.concordia.dao
 * @Date: 2/20/2022 00:49
 */
public class BaseDao<T> {
	private QueryRunner queryRunner = new QueryRunner();
	
	/**
	 * @Author Wei Qi
	 * @Description execute SQL - Add,Del,Update
	 * @Date 2/20/2022 12:52 AM
	 * @Param [sql, params]
	 * @return int
	 */
	public int update(String sql, Object... params){
		Connection connection = JDBCUtil.getConnection();
		try {
			return queryRunner.update(connection, sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}finally {
			JDBCUtil.releaseConnection(connection);
		}
	}

	/**
	 * @Author Wei Qi
	 * @Description  execute sql to get one object and encapsulate into JavaBean
	 * @Date 2/20/2022 12:56 AM
	 * @Param [clazz, sql, params]
	 * @return T
	 */
	public T getBean(Class<T> clazz, String sql, Object... params){
		Connection connection = JDBCUtil.getConnection();
		try {
			return queryRunner.query(connection, sql, new BeanHandler<>(clazz), params);
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}finally {
			JDBCUtil.releaseConnection(connection);
		}
	}

	/**
	 * @Author Wei Qi
	 * @Description execute sql to get object list and encapsulate the results into JavaBean
	 * @Date 2/20/2022 1:00 AM
	 * @Param [clazz, sql, params]
	 * @return java.util.List<T>
	 */
	public List<T> getBeanList(Class<T> clazz, String sql, Object... params){
		Connection connection = JDBCUtil.getConnection();
		try {
			return queryRunner.query(connection, sql, new BeanListHandler<>(clazz), params);
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}finally {
			JDBCUtil.releaseConnection(connection);
		}
	}

	public List<Object> getStringList(String sql){
		Connection connection = JDBCUtil.getConnection();
		try {
			return queryRunner.query(connection, sql, new ColumnListHandler());
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}finally {
			JDBCUtil.releaseConnection(connection);
		}
	}

	public int getTotalCount(String sql,Object... params){
		Connection connection = JDBCUtil.getConnection();
		try {
			Long count = (Long) queryRunner.query(connection,sql,new ScalarHandler(),params);
			return count.intValue();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}finally {
			JDBCUtil.releaseConnection(connection);
		}
	}

	public String getSingleValue(String sql,Object... params){
		Connection connection = JDBCUtil.getConnection();
		try {
			String singleValue = (String) queryRunner.query(connection,sql,new ScalarHandler(),params);
			return singleValue;
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}finally {
			JDBCUtil.releaseConnection(connection);
		}
	}



	public int[] batchUpdate(String sql, Object[][] paramArr){
		Connection connection = JDBCUtil.getConnection();
		try {
			return queryRunner.batch(connection,sql,paramArr);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}finally {
			JDBCUtil.releaseConnection(connection);
		}
	}

}




























