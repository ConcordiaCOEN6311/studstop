package com.concordia.dao;

import com.concordia.bean.Book;
import com.concordia.bean.Category;

import java.sql.SQLException;
import java.util.List;

public interface BookDao {
	List<Category> getCatList() throws SQLException;
	List<Book> getBookGridPageByCatId(int index, int currentCount, int catId) throws SQLException;
	int getBookTotalCountByCatId(int catId) throws SQLException;
}
