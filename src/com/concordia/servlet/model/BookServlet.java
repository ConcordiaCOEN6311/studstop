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
		Page<Book> bookGridPage = bookService.findBookPageByCatId(currentPage, currentCount, Integer.parseInt(catId));
		List<Book> infoList = bookGridPage.getInfoList();

		int index = (currentPage - 1) * currentCount;

		request.setAttribute("bookGridPage", bookGridPage);
		request.setAttribute("index",index);
		request.getSession().setAttribute("catId", catId);
		request.getSession().setAttribute("catName", catName);
		processTemplate("book/shop_grid",request,response);
	}
	public void toShopListPageByCatId(HttpServletRequest request,HttpServletResponse response) throws Exception {
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
		int currentCount = 5;
		Page<Book> bookListPage = bookService.findBookPageByCatId(currentPage, currentCount, Integer.parseInt(catId));
		List<Book> infoList = bookListPage.getInfoList();
		int index = (currentPage - 1) * currentCount;
		request.setAttribute("bookListPage", bookListPage);
		request.setAttribute("index",index);
		request.getSession().setAttribute("catId", catId);
		request.getSession().setAttribute("catName", catName);
		processTemplate("book/shop_list",request,response);
	}

	public void toBookDetailPage(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String bookId = request.getParameter("bookId");
		Book bookDetail = bookService.findBookById(Integer.valueOf(bookId));
		request.setAttribute("bookDetail", bookDetail);
		processTemplate("book/book_details",request,response);
	}

	/**
	 *
	 * @param request
	 * @param response
	 * @throws Exception
	 */

	public void toSearchResultsListByName(HttpServletRequest request, HttpServletResponse response) throws Exception{

		String cp = request.getParameter("currentPage");
		String bookName = request.getParameter("bookName");
		int currentPage = 1;
		if (cp != null) {
			Integer cpInt = Integer.valueOf(cp);
			if (cpInt != -1) {
				currentPage = cpInt;
			}
		}
		int currentCount = 5;
		Page<Book> bookListPage = bookService.findBookPageByName(currentPage, currentCount, bookName);
		List<Book> infoList = bookListPage.getInfoList();
		int index = (currentPage - 1) * currentCount;
		request.setAttribute("bookListPage", bookListPage);
		request.setAttribute("index",index);
		request.getSession().setAttribute("bookName", bookName);
		processTemplate("book/search_list", request, response);

	}

	public void toSearchResultsGridByName(HttpServletRequest request, HttpServletResponse response) throws Exception{

		String cp = request.getParameter("currentPage");
		String bookName = request.getParameter("bookName");
		int currentPage = 1;
		if (cp != null) {
			Integer cpInt = Integer.valueOf(cp);
			if (cpInt != -1) {
				currentPage = cpInt;
			}
		}
		int currentCount = 16;
		Page<Book> bookGridPage= bookService.findBookPageByName(currentPage, currentCount, bookName);
		List<Book> infoList = bookGridPage.getInfoList();
		int index = (currentPage - 1) * currentCount;
		request.setAttribute("bookGridPage", bookGridPage);
		request.setAttribute("index",index);
		request.getSession().setAttribute("bookName", bookName);
		processTemplate("book/search_grid", request, response);

	}

}

























