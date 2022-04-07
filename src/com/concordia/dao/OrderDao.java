package com.concordia.dao;

import com.concordia.bean.Order;

import java.sql.SQLException;

public interface OrderDao {
	void insertOrder(Order order) throws SQLException;
}
