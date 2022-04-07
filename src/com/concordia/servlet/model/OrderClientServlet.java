package com.concordia.servlet.model;

import com.concordia.bean.Cart;
import com.concordia.bean.Student;
import com.concordia.constant.MyConstants;
import com.concordia.service.OrderService;
import com.concordia.service.impl.OrderServiceImpl;
import com.concordia.servlet.base.ModelBaseServlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

public class OrderClientServlet extends ModelBaseServlet {
	private OrderService orderService = new OrderServiceImpl();
	public void checkoutShoppingCart(HttpServletRequest request,HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute(MyConstants.CART_SESSION_KEY);
		Student loginUser = (Student) session.getAttribute(MyConstants.USER_SESSION_KEY);
		String orderSequence = null;
		try {
			orderSequence = orderService.checkout(loginUser, cart);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		session.removeAttribute(MyConstants.CART_SESSION_KEY);

		request.setAttribute("orderSequence", orderSequence);
		processTemplate("cart/cart",request,response);
	}
}
