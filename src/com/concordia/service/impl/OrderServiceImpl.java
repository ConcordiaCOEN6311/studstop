package com.concordia.service.impl;

import com.concordia.bean.Cart;
import com.concordia.bean.CartItem;
import com.concordia.bean.Order;
import com.concordia.bean.Student;
import com.concordia.constant.MyConstants;
import com.concordia.constant.UUID22;
import com.concordia.dao.BookDao;
import com.concordia.dao.OrderDao;
import com.concordia.dao.OrderItemDao;
import com.concordia.dao.impl.BookDaoImpl;
import com.concordia.dao.impl.OrderDaoImpl;
import com.concordia.dao.impl.OrderItemDaoImpl;
import com.concordia.service.OrderService;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author: Wei Qi
 * @Package: com.concordia.service.impl
 * @Date: 4/7/2022 00:43
 */
public class OrderServiceImpl implements OrderService {
	private OrderDao orderDao = new OrderDaoImpl();
	private OrderItemDao orderItemDao = new OrderItemDaoImpl();
	private BookDao bookDao = new BookDaoImpl();
	@Override
	public String checkout(Student student, Cart cart) throws SQLException {

		Order order = new Order();
		String orderSequence = UUID22.generateShortUuid();
		order.setOrderSequence(orderSequence);

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");
		String createTime = dateFormat.format(new Date());
		order.setCreateTime(createTime);

		order.setTotalCount(cart.getTotalCount());
		order.setTotalAmount(cart.getTotalAmount());

		order.setOrderStatus(MyConstants.ORDER_STATUS_PLACED_ORDER);
		order.setUserId(student.getStudentId());

		orderDao.insertOrder(order);

		Map<Integer, CartItem> cartItemMap = cart.getCartItemMap();
		Collection<CartItem> cartItemCollection = cartItemMap.values();
		List<CartItem> cartItemList = new ArrayList<>(cartItemCollection);

		Object[][] orderItems = new Object[cartItemList.size()][6];
		Object[][] bookStocks = new Object[cartItemList.size()][3];

		for (int i = 0; i < cartItemList.size(); i++) {
			CartItem cartItem = cartItemList.get(i);
			orderItems[i][0] = cartItem.getBookName();
			orderItems[i][1] = cartItem.getPrice();
			orderItems[i][2] = cartItem.getImgPath();
			orderItems[i][3] = cartItem.getCount();
			orderItems[i][4] = cartItem.getAmount();
			orderItems[i][5] = order.getOrderId();

			bookStocks[i][0] = cartItem.getCount();
			bookStocks[i][1] = cartItem.getCount();
			bookStocks[i][2] = cartItem.getBookId();
		}

		orderItemDao.insertOrderItems(orderItems);

		bookDao.updateBookStocks(bookStocks);

		return orderSequence;
	}
}



































