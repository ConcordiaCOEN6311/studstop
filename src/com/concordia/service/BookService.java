package com.concordia.service;

import com.concordia.bean.Book;
import com.concordia.bean.Category;
import com.concordia.bean.Page;
import com.concordia.dao.BookDao;
import com.concordia.dao.impl.BookDaoImpl;

import java.util.List;

public interface BookService {
	List<Category> showCatList() throws Exception;
	Page findBookPageByCatId(int currentPage, int currentCount, int catId) throws Exception;
	Book findBookById(Integer bookId) throws Exception;

	/**
	 *
	 * @param currentPage
	 * @param currentCount
	 * @param bookName
	 * @return
	 * @throws Exception
	 */
	Page findBookPageByName(int currentPage, int currentCount, String bookName) throws Exception;
}
