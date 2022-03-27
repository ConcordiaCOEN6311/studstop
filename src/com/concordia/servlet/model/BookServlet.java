package com.concordia.servlet.model;

import com.concordia.bean.Book;
import com.concordia.bean.Page;
import com.concordia.service.BookService;
import com.concordia.service.impl.BookServiceImpl;
import com.concordia.servlet.base.ModelBaseServlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class BookServlet extends ModelBaseServlet {
	private BookService bookService = new BookServiceImpl();
	public void toShopGridPageByCatId(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String cp = request.getParameter("currentPage");
		String catId = request.getParameter("catId");
		String catName = request.getParameter("catName");
		int currentPage = 1;
		if (cp != null) {
			Integer cpInt = Integer.valueOf(cp);
			if (cpInt != -1) {
				currentPage = cpInt;
			}
		}
		int currentCount = 16;
		Page<Book> bookGridPage = bookService.findBookGridPageByCatId(currentPage, currentCount, Integer.parseInt(catId));
		List<Book> infoList = bookGridPage.getInfoList();

		request.setAttribute("bookGridPage", bookGridPage);
		request.getSession().setAttribute("catId", catId);
		request.getSession().setAttribute("catName", catName);
		processTemplate("book/shop_grid",request,response);
	}
}
