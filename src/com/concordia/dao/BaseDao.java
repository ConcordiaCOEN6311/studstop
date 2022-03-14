package com.concordia.dao;

import com.concordia.utils.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: Wei Qi
 * @Package: com.atguigu.dao
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
		try {
			return queryRunner.update(JDBCUtil.getConnection(), sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
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
		try {
			return queryRunner.query(JDBCUtil.getConnection(), sql, new BeanHandler<>(clazz), params);
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
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
		try {
			return queryRunner.query(JDBCUtil.getConnection(), sql, new BeanListHandler<>(clazz), params);
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}
