package com.concordia.service;

import com.concordia.bean.Cart;
import com.concordia.bean.Student;

import java.sql.SQLException;

public interface OrderService {
	String checkout(Student student, Cart cart) throws SQLException;
}
