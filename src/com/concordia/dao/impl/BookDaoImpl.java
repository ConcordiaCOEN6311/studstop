package com.concordia.dao.impl;

import com.concordia.bean.Book;
import com.concordia.bean.Category;
import com.concordia.dao.BaseDao;
import com.concordia.dao.BookDao;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: Wei Qi
 * @Package: com.concordia.dao.impl
 * @Date: 3/27/2022 01:46
 */
public class BookDaoImpl extends BaseDao implements BookDao {
	@Override
	public List<Category> getCatList() throws SQLException {
		String sql = "select category_id as categoryId,category_name as categoryName from category";
		return getBeanList(Category.class,sql);
	}

	@Override
	public List<Book> getBookPageByCatId(int index, int currentCount, int catId) throws SQLException {
		String sql = "select book_id as bookId,book_name as bookName,author,price,category_id as categoryId,sales,sale_stock as saleStock,rent_stock as rentStock,imgPath,discount,rate,description,create_date as creatDate,book_detail as bookDetail from book where book.category_id=? limit ? , ?";
		return getBeanList(Book.class,sql,catId,index,currentCount);
	}

	@Override
	public int getBookTotalCountByCatId(int catId) throws SQLException {
		String sql = "select count(*) from book where category_id = ?";
		return getTotalCount(sql,catId);
	}

	@Override
	public Book getBookById(Integer bookId) {
		String sql = "select book_id as bookId,book_name as bookName,author,price,category_id as categoryId,sales,sale_stock as saleStock,rent_stock as rentStock,imgPath,discount,rate,description,create_date as creatDate,book_detail as bookDetail from book where book_id=?";
		return (Book) getBean(Book.class,sql,bookId);
	}


	/**
	 *
	 * @param index
	 * @param currentCount
	 * @param bookName
	 * @return
	 * @throws SQLException
	 */

	@Override
	public List<Book> getBookPageByName(int index, int currentCount, String bookName) throws SQLException {
		String params ="%"+bookName+"%";
		String sql = "select book_id as bookId,book_name as bookName,author,price,category_id as categoryId,sales,sale_stock as saleStock,rent_stock as rentStock,imgPath,discount,rate,description,create_date as creatDate,book_detail as bookDetail from book where book_name like ? limit ? , ?";
		return getBeanList(Book.class,sql,params,index,currentCount);
	}

	@Override
	public int getBookTotalCountByName(String bookName) throws SQLException {
		String params ="%"+bookName+"%";
		String sql = "select count(*) from book where book_name like ?";
		return getTotalCount(sql,params);
	}

}
