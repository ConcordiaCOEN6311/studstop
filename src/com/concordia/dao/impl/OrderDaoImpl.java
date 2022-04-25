package com.concordia.dao.impl;

import com.concordia.bean.Order;
import com.concordia.dao.BaseDao;
import com.concordia.dao.OrderDao;
import com.concordia.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author: Wei Qi
 * @Package: com.concordia.service.impl
 * @Date: 4/7/2022 00:44
 */
public class OrderDaoImpl extends BaseDao implements OrderDao {
	@Override
	public void insertOrder(Order order) throws SQLException {
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		Connection connection = JDBCUtil.getConnection();
		String sql = "insert into s_order(order_sequence,create_time,total_count,total_amount,order_status,s_id) values (?,?,?,?,?,?)";
		try {
			preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStatement.setObject(1, order.getOrderSequence());
			preparedStatement.setObject(2, order.getCreateTime());
			preparedStatement.setObject(3, order.getTotalCount());
			preparedStatement.setObject(4, order.getTotalAmount());
			preparedStatement.setObject(5, order.getOrderStatus());
			preparedStatement.setObject(6, order.getUserId());

			preparedStatement.executeUpdate();

			resultSet = preparedStatement.getGeneratedKeys();
			if (resultSet.next()) {
				int orderId = resultSet.getInt(1);
				order.setOrderId(orderId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			resultSet.close();
			preparedStatement.close();
			JDBCUtil.releaseConnection(connection);
		}
	}
}
