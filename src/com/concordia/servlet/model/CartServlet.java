package com.concordia.servlet.model;

import com.concordia.bean.Book;
import com.concordia.bean.Cart;
import com.concordia.service.BookService;
import com.concordia.service.impl.BookServiceImpl;
import com.concordia.servlet.base.ModelBaseServlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class CartServlet extends ModelBaseServlet {
	private BookService bookService = new BookServiceImpl();
	public void addCartItem(HttpServletRequest request,HttpServletResponse response){
		Integer id = Integer.valueOf(request.getParameter("id"));
		try {
			Book book = bookService.findBookById(id);
			HttpSession session = request.getSession();
			Cart cart = (Cart) session.getAttribute("cart");
			if(cart == null){
				cart = new Cart();
				cart.addBookToCart(book);
				session.setAttribute("cart",cart);
			}else {
				cart.addBookToCart(book);
			}
			response.sendRedirect(request.getContextPath() + "/index.html");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void toCartPage(HttpServletRequest request,HttpServletResponse response) throws IOException {
		processTemplate("cart/cart",request,response);
	}
}
