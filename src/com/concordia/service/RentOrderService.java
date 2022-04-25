package com.concordia.service;

import com.concordia.bean.RentalCart;
import com.concordia.bean.Student;

import java.sql.SQLException;
import java.text.ParseException;

public interface RentOrderService {
	String checkout(Student student, RentalCart cart) throws ParseException, SQLException;
}
