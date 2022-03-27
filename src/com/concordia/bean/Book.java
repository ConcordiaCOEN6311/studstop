package com.concordia.bean;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.NumberFormat;
import java.text.ParseException;

/**
 * @Author: Wei Qi
 * @Package: com.concordia.bean
 * @Date: 3/26/2022 21:32
 */
public class Book {
	private Integer bookId;
	private String bookName;
	private String author;
	private Double price;
	private String category;
	private Integer sales;
	private Integer saleStock;
	private Integer rentStock;
	private String imgPath;
	private String discount;
	private Integer rate;
	private String description;
	private Date creatDate;
	private Double finalPrice;
	private String newArrivedIndicator;

	public Book() {
	}

	public Book(Integer bookId, String bookName, String author, Double price, String category, Integer sales, Integer saleStock, Integer rentStock, String imgPath, String discount, Integer rate, String description, Date creatDate, Double discountPrice, String newArrivedIndicator) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.author = author;
		this.price = price;
		this.category = category;
		this.sales = sales;
		this.saleStock = saleStock;
		this.rentStock = rentStock;
		this.imgPath = imgPath;
		this.discount = discount;
		this.rate = rate;
		this.description = description;
		this.creatDate = creatDate;
		this.finalPrice = finalPrice;
		this.newArrivedIndicator = newArrivedIndicator;
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getSales() {
		return sales;
	}

	public void setSales(Integer sales) {
		this.sales = sales;
	}

	public Integer getSaleStock() {
		return saleStock;
	}

	public void setSaleStock(Integer saleStock) {
		this.saleStock = saleStock;
	}

	public Integer getRentStock() {
		return rentStock;
	}

	public void setRentStock(Integer rentStock) {
		this.rentStock = rentStock;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public Integer getRate() {
		return rate;
	}

	public void setRate(Integer rate) {
		this.rate = rate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatDate() {
		return creatDate;
	}

	public void setCreatDate(Date creatDate) {
		this.creatDate = creatDate;
	}

	public Double getFinalPrice() throws ParseException {

		if(this.discount == null || "".equals(this.discount)){
			return this.price;
		}else {
			NumberFormat numberFormat = NumberFormat.getPercentInstance();
			Number numberRate = numberFormat.parse(discount);

			BigDecimal bigDecimalPrice = new BigDecimal(price + "");
			BigDecimal bigDecimalRate = new BigDecimal(numberRate + "");

			this.finalPrice = price - bigDecimalRate.multiply(bigDecimalPrice).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

			return this.finalPrice;
		}
	}

	public void setFinalPrice(Double finalPrice) {
		this.finalPrice = finalPrice;
	}

	public String getNewArrivedIndicator() throws ParseException {
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		long startDateTime = dateFormat.parse(dateFormat.format(this.creatDate)).getTime();
		long endDateTime = dateFormat.parse(dateFormat.format(currentDate)).getTime();
		Integer differDate = (int) ((endDateTime - startDateTime) / (1000 * 3600 * 24));
		if(differDate > 7){
			this.newArrivedIndicator = "N";
		}else {
			this.newArrivedIndicator = "Y";
		}
		return this.newArrivedIndicator;
	}

	public void setNewArrivedIndicator(String newArrivedIndicator) {
		this.newArrivedIndicator = newArrivedIndicator;
	}

	@Override
	public String toString() {
		return "Book{" +
				"bookId=" + bookId +
				", bookName='" + bookName + '\'' +
				", author='" + author + '\'' +
				", price=" + price +
				", category='" + category + '\'' +
				", sales=" + sales +
				", saleStock=" + saleStock +
				", rentStock=" + rentStock +
				", imgPath='" + imgPath + '\'' +
				", discount='" + discount + '\'' +
				", rate=" + rate +
				", description='" + description + '\'' +
				", creatDate=" + creatDate +
				", discountPrice=" + finalPrice +
				", newArrivedIndicator='" + newArrivedIndicator + '\'' +
				'}';
	}
}
