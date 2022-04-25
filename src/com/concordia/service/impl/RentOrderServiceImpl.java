package com.concordia.service.impl;

import com.concordia.bean.*;
import com.concordia.constant.UUID22;
import com.concordia.dao.BookDao;
import com.concordia.dao.RentOrderDao;
import com.concordia.dao.RentOrderItemDao;
import com.concordia.dao.impl.BookDaoImpl;
import com.concordia.dao.impl.RentOrderDaoImpl;
import com.concordia.dao.impl.RentOrderItemDaoImpl;
import com.concordia.service.RentOrderService;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author: Wei Qi
 * @Package: com.concordia.service.impl
 * @Date: 4/24/2022 23:08
 */
public class RentOrderServiceImpl implements RentOrderService {
	RentOrderDao rentOrderDao = new RentOrderDaoImpl();
	RentOrderItemDao rentOrderItemDao = new RentOrderItemDaoImpl();
	private BookDao bookDao = new BookDaoImpl();
	@Override
	public String checkout(Student student, RentalCart cart) throws ParseException, SQLException {
		Rental rental = new Rental();
		String rentalSequence = UUID22.generateShortUuid();
		rental.setRentSequence(rentalSequence);

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");
		String createTime = dateFormat.format(new Date());
		rental.setCreateTime(createTime);

		rental.setTotalCount(cart.getTotalCount());
		rental.setTotalAmount(cart.getTotalAmount());

		rental.setUserId(student.getStudentId());

		rental.setAppointmentDate(cart.getAppointmentDate());
		rental.setAppointmentTime(cart.getAppointmentTime());

		rentOrderDao.insertRentOrder(rental);

		Map<Integer, RentalCartItem> cartItemMap = cart.getRentalCartItemMap();
		Collection<RentalCartItem> cartItemCollection = cartItemMap.values();
		List<RentalCartItem> cartItemList = new ArrayList<>(cartItemCollection);

		Object[][] orderItems = new Object[cartItemList.size()][7];
		Object[][] bookRentStocks = new Object[cartItemList.size()][1];
		for (int i = 0; i < cartItemList.size(); i++) {
			RentalCartItem rentalCartItem = cartItemList.get(i);
			orderItems[i][0] = rentalCartItem.getBookName();
			orderItems[i][1] = rentalCartItem.getRentPrice();
			orderItems[i][2] = rentalCartItem.getImgPath();
			orderItems[i][3] = this.getReturnDate(rental.getAppointmentDate(), rentalCartItem.getRentalDays());
			orderItems[i][4] = rentalCartItem.getRentalDays();
			orderItems[i][5] = rentalCartItem.getAmount();
			orderItems[i][6] = rental.getRentId();

			bookRentStocks[i][0] = rentalCartItem.getBookId();
		}

		rentOrderItemDao.insertRentOrderItem(orderItems);

		bookDao.updateBookRentalStocks(bookRentStocks);

		return rentalSequence;
	}

	public String getReturnDate(String aptDate, Integer rentalDay) throws ParseException {
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		Date apt_date = ft.parse(aptDate);
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(apt_date);
		calendar.add(calendar.DATE,rentalDay);

		return ft.format(calendar.getTime());
	}
}
