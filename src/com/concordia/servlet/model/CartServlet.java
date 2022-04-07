package com.concordia.servlet.model;

import com.concordia.bean.Book;
import com.concordia.bean.Cart;
import com.concordia.bean.RentalCart;
import com.concordia.service.BookService;
import com.concordia.service.CartService;
import com.concordia.service.impl.BookServiceImpl;
import com.concordia.service.impl.CartServiceImpl;
import com.concordia.servlet.base.ModelBaseServlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

public class CartServlet extends ModelBaseServlet {
	private BookService bookService = new BookServiceImpl();
	private CartService cartService = new CartServiceImpl();
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
					rentalCart.addBookToRentalCart(book);
					session.setAttribute("rentalCart",rentalCart);
				}else {
					rentalCart.addBookToRentalCart(book);
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

	public void toRentalCartPage(HttpServletRequest request,HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		RentalCart rentalCart = (RentalCart) session.getAttribute("rentalCart");
		if(rentalCart!=null){
			List<String> appointmentDateList = cartService.showAppointmentDate();
			session.setAttribute("aptTimeList", appointmentDateList);
		}
		processTemplate("cart/rentalCart",request,response);
	}

	public void cleanShoppingCart(HttpServletRequest request,HttpServletResponse response) throws IOException {
		request.getSession().removeAttribute("cart");
		processTemplate("cart/cart",request,response);
	}

	public void cleanRentalCart(HttpServletRequest request,HttpServletResponse response) throws IOException {
		request.getSession().removeAttribute("rentalCart");
		processTemplate("cart/rentalCart",request,response);
	}

	public void removeShoppingCartItem(HttpServletRequest request,HttpServletResponse response) throws IOException {
		Integer id = Integer.valueOf(request.getParameter("id"));
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		cart.removeCartItem(id);
		processTemplate("cart/cart",request,response);
	}

	public void removeRentalCartItem(HttpServletRequest request,HttpServletResponse response) throws IOException {
		Integer id = Integer.valueOf(request.getParameter("id"));
		RentalCart rentalCart = (RentalCart) request.getSession().getAttribute("rentalCart");
		rentalCart.removeRentalCartItem(id);
		processTemplate("cart/rentalCart",request,response);
	}

	public void updateShoppingCart(HttpServletRequest request,HttpServletResponse response) throws Exception {
		Integer id = Integer.valueOf(request.getParameter("id"));
		Integer newCount = Integer.valueOf(request.getParameter("newCount"));

		Cart cart = (Cart) request.getSession().getAttribute("cart");
		Book book = bookService.findBookById(id);
		if(book.getSaleStock()>newCount){
			cart.updateItemCount(id,newCount);
		}else {
			request.setAttribute("errorMessage", "Update failed, we do not have enough stock");
		}
		processTemplate("cart/cart",request,response);
	}

	public void updateRentalCart(HttpServletRequest request,HttpServletResponse response) throws Exception {
		Integer id = Integer.valueOf(request.getParameter("id"));
		Integer newCount = Integer.valueOf(request.getParameter("newCount"));

		RentalCart rentalCart = (RentalCart) request.getSession().getAttribute("rentalCart");

		Book book = bookService.findBookById(id);
		if(book.getRentStock()>newCount){
			rentalCart.updateItemRentalDays(id,newCount);
		}else {
			request.setAttribute("errorMessage", "Update failed, we do not have enough stock");
		}

		processTemplate("cart/rentalCart",request,response);
	}

	public void updateAptTime(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String aptTime = request.getParameter("aptTime");
		RentalCart rentalCart = (RentalCart) request.getSession().getAttribute("rentalCart");
		rentalCart.setAppointmentTime(aptTime);
		processTemplate("cart/rentalCart",request,response);
	}

	public void updateAptDate(HttpServletRequest request,HttpServletResponse response) throws Exception {
		Date aptDate = Date.valueOf(request.getParameter("aptDate"));
		RentalCart rentalCart = (RentalCart) request.getSession().getAttribute("rentalCart");
		rentalCart.setAppointmentDate(aptDate);
		processTemplate("cart/rentalCart",request,response);
	}

}


































