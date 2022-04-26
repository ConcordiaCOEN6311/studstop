package com.concordia.dao;

import com.concordia.bean.Book;
import com.concordia.bean.Category;


import java.sql.SQLException;
import java.util.List;

public interface BookDao {
	List<Category> getCatList() throws SQLException;
	List<Book> getBookPageByCatId(int index, int currentCount, int catId) throws SQLException;
	int getBookTotalCountByCatId(int catId) throws SQLException;
	Book getBookById(Integer bookId);

	List<Book> getBookPageByName(int index, int currentCount, String bookName, int catId) throws SQLException;
	int getBookTotalCountByName(String bookName) throws SQLException;
	void updateBookStocks(Object[][] bookStocks) throws SQLException;
	void updateBookRentalStocks(Object[][] rentalStocks) throws SQLException;
	String getCatNameById(int catId) throws SQLException;
}
