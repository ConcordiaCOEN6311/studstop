package com.concordia.service.impl;

import com.concordia.bean.Book;
import com.concordia.bean.Category;
import com.concordia.bean.Page;
import com.concordia.dao.BookDao;
import com.concordia.dao.impl.BookDaoImpl;
import com.concordia.service.BookService;

import java.util.List;

/**
 * @Author: Wei Qi
 * @Package: com.concordia.service.impl
 * @Date: 3/27/2022 01:50
 */
public class BookServiceImpl implements BookService {
	private BookDao bookDao = new BookDaoImpl();
	@Override
	public List<Category> showCatList() throws Exception {
		return bookDao.getCatList();
	}

	@Override
	public Page findBookGridPageByCatId(int currentPage, int currentCount, int catId) throws Exception {
		Page<Book> bookGridPage = new Page<>();
		int bookTotalCount = bookDao.getBookTotalCountByCatId(catId);
		int bookTotalPage = (int) Math.ceil(1.0 * bookTotalCount / currentCount);
		int index = (currentPage - 1) * currentCount;
		List<Book> bookGridPageByCatId = bookDao.getBookGridPageByCatId(index,currentCount,catId);

		bookGridPage.setInfoList(bookGridPageByCatId);
		bookGridPage.setCurrentPage(currentPage);
		bookGridPage.setCurrentCount(currentCount);
		bookGridPage.setTotalCount(bookTotalCount);
		bookGridPage.setTotalPage(bookTotalPage);

		return bookGridPage;
	}
}
