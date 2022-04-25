package com.concordia.dao.impl;

import com.concordia.bean.Rental;
import com.concordia.dao.BaseDao;
import com.concordia.dao.RentOrderDao;
import com.concordia.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author: Wei Qi
 * @Package: com.concordia.service.impl
 * @Date: 4/25/2022 00:11
 */
public class RentOrderDaoImpl extends BaseDao implements RentOrderDao {
	@Override
	public void insertRentOrder(Rental rental){
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		Connection connection = JDBCUtil.getConnection();
		String sql = "insert into rent(rent_sequence,create_time,total_count,total_amount,appointment_time,appointment_date,s_id) values (?,?,?,?,?,?,?)";
		try {
			preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStatement.setObject(1, rental.getRentSequence());
			preparedStatement.setObject(2, rental.getCreateTime());
			preparedStatement.setObject(3, rental.getTotalCount());
			preparedStatement.setObject(4, rental.getTotalAmount());
			preparedStatement.setObject(5, rental.getAppointmentTime());
			preparedStatement.setObject(6, rental.getAppointmentDate());
			preparedStatement.setObject(7, rental.getUserId());

			preparedStatement.executeUpdate();

			resultSet = preparedStatement.getGeneratedKeys();
			if (resultSet.next()) {
				int orderId = resultSet.getInt(1);
				rental.setRentId(orderId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				JDBCUtil.releaseConnection(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
