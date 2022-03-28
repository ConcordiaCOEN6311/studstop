package com.concordia.bean;

import java.math.BigDecimal;

/**
 * @Author: Wei Qi
 * @Date: 3/26/2022 05:18
 */
public class CartItem {
	private Integer bookId;
	private String bookName;
	private String imgPath;
	private Double price;
	private Integer count;
	private Double amount;

	public CartItem() {
	}

	public CartItem(Integer bookId, String bookName, String imgPath, Double price, Integer count, double amount) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.imgPath = imgPath;
		this.price = price;
		this.count = count;
		this.amount = amount;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Double getAmount() {
		BigDecimal bigDecimalPrice = new BigDecimal(price + "");
		BigDecimal bigDecimalCount = new BigDecimal(count + "");
		this.amount = bigDecimalCount.multiply(bigDecimalPrice).doubleValue();
		return this.amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public void countIncrease(){
		this.count++;
	}

	public void countDecrease(){
		this.count--;
	}

	@Override
	public String toString() {
		return "CartItem{" +
				"bookId=" + bookId +
				", bookName='" + bookName + '\'' +
				", imgPath='" + imgPath + '\'' +
				", price=" + price +
				", count=" + count +
				", amount=" + amount +
				'}';
	}
}
