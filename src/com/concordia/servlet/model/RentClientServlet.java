package com.concordia.servlet.model;

import com.concordia.bean.Cart;
import com.concordia.bean.RentalCart;
import com.concordia.bean.Student;
import com.concordia.constant.MyConstants;
import com.concordia.service.RentOrderService;
import com.concordia.service.impl.RentOrderServiceImpl;
import com.concordia.servlet.base.ModelBaseServlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

public class RentClientServlet extends ModelBaseServlet {
	private RentOrderService rentOrderService = new RentOrderServiceImpl();
	public void checkoutRentalCart(HttpServletRequest request,HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		RentalCart cart = (RentalCart) session.getAttribute(MyConstants.RENTAL_CART_SESSION_KEY);
		Student loginUser = (Student) session.getAttribute(MyConstants.USER_SESSION_KEY);
		String rentSequence = null;
		try {
			rentSequence = rentOrderService.checkout(loginUser, cart);
		} catch (Exception e) {
			e.printStackTrace();
		}

		session.removeAttribute(MyConstants.RENTAL_CART_SESSION_KEY);

		request.setAttribute("rentSequence", rentSequence);
		processTemplate("cart/rentalCart",request,response);
	}
}
