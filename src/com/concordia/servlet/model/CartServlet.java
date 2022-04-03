package com.concordia.servlet.model;

import com.concordia.bean.Book;
import com.concordia.bean.Cart;
import com.concordia.bean.RentalCart;
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
		String view = request.getParameter("view");
		String catId = request.getParameter("catId");
		String currentPage = request.getParameter("currentPage");
		String catName = request.getParameter("catName");
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

			if("grid".equals(view)){
				response.sendRedirect(request.getContextPath() + "/book?method=toShopGridPageByCatId&currentPage="+currentPage+"&catId="+catId+"&catName="+catName);
			}
			if("list".equals(view)){
				response.sendRedirect(request.getContextPath() + "/book?method=toShopListPageByCatId&currentPage="+currentPage+"&catId="+catId+"&catName="+catName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addRentCartItem(HttpServletRequest request,HttpServletResponse response){
		{
			Integer id = Integer.valueOf(request.getParameter("id"));
			String view = request.getParameter("view");
			String catId = request.getParameter("catId");
			String currentPage = request.getParameter("currentPage");
			String catName = request.getParameter("catName");
			try {
				Book book = bookService.findBookById(id);
				HttpSession session = request.getSession();
				RentalCart rentalCart = (RentalCart) session.getAttribute("rentalCart");
				if(rentalCart == null){
					rentalCart = new RentalCart();
					rentalCart.addBookToCart(book);
					session.setAttribute("rentalCart",rentalCart);
				}else {
					rentalCart.addBookToCart(book);
				}

				if("grid".equals(view)){
					response.sendRedirect(request.getContextPath() + "/book?method=toShopGridPageByCatId&currentPage="+currentPage+"&catId="+catId+"&catName="+catName);
				}
				if("list".equals(view)){
					response.sendRedirect(request.getContextPath() + "/book?method=toShopListPageByCatId&currentPage="+currentPage+"&catId="+catId+"&catName="+catName);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void toCartPage(HttpServletRequest request,HttpServletResponse response) throws IOException {
		processTemplate("cart/cart",request,response);
	}

	public void toRentalCartPage(HttpServletRequest request,HttpServletResponse response) throws IOException {
		processTemplate("cart/rentalCart",request,response);
	}
}
