package com.concordia.bean;

import java.math.BigDecimal;

/**
 * @Author: Wei Qi
 * @Package: com.concordia.bean
 * @Date: 4/6/2022 01:41
 */
public class RentalCartItem {
	private Integer bookId;
	private String bookName;
	private String imgPath;
	private Double rentPrice;
	private Integer rentalDays;
	private Integer count;
	private Double amount;

	public RentalCartItem() {
	}

	public RentalCartItem(Integer bookId, String bookName, String imgPath, Double rentPrice, Integer rentalDays, Integer count, Double amount) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.imgPath = imgPath;
		this.rentPrice = rentPrice;
		this.rentalDays = rentalDays;
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

	public Double getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(Double rentPrice) {
		this.rentPrice = rentPrice;
	}

	public Integer getRentalDays() {
		return rentalDays;
	}

	public void setRentalDays(Integer rentalDays) {
		this.rentalDays = rentalDays;
	}

	public Double getAmount() {
		BigDecimal bigDecimalPrice = new BigDecimal(rentPrice + "");
		BigDecimal bigDecimalCount = new BigDecimal(rentalDays + "");

		BigDecimal fp= BigDecimal.valueOf(bigDecimalCount.multiply(bigDecimalPrice).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
		this.amount = fp.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
		return this.amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	public void countIncrease(){
		this.count++;
	}

	public void countDecrease(){
		this.count--;
	}
}
