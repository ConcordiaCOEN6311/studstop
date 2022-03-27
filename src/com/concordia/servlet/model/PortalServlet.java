package com.concordia.servlet.model;

import com.concordia.bean.Category;
import com.concordia.service.BookService;
import com.concordia.service.impl.BookServiceImpl;
import com.concordia.servlet.base.ModelBaseServlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class PortalServlet extends ModelBaseServlet {
	private BookService bookService = new BookServiceImpl();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Category> categoryList = bookService.showCatList();
			request.setAttribute("catList", categoryList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		processTemplate("index",request,response);
	}
}
