package com.concordia.service;

import com.concordia.bean.Category;
import com.concordia.bean.Page;
import com.concordia.dao.BookDao;
import com.concordia.dao.impl.BookDaoImpl;

import java.util.List;

public interface BookService {
	List<Category> showCatList() throws Exception;
	Page findBookGridPageByCatId(int currentPage, int currentCount, int catId) throws Exception;
}
