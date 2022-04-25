package com.concordia.bean;

/**
 * @Author: Wei Qi
 * @Package: com.concordia.bean
 * @Date: 4/25/2022 00:32
 */
public class RentItem {
	private Integer itemId;
	private String bookName;
	private Double rentFee;
	private String imgPath;
	private String returnDate;
	private Integer rentalDay;
	private Double itemAmount;
	private Integer rentId;

	public RentItem() {
	}

	public RentItem(Integer itemId, String bookName, Double rentFee, String imgPath, String returnDate, Integer rentalDay, Double itemAmount, Integer rentId) {
		this.itemId = itemId;
		this.bookName = bookName;
		this.rentFee = rentFee;
		this.imgPath = imgPath;
		this.returnDate = returnDate;
		this.rentalDay = rentalDay;
		this.itemAmount = itemAmount;
		this.rentId = rentId;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Double getRentFee() {
		return rentFee;
	}

	public void setRentFee(Double rentFee) {
		this.rentFee = rentFee;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public Integer getRentalDay() {
		return rentalDay;
	}

	public void setRentalDay(Integer rentalDay) {
		this.rentalDay = rentalDay;
	}

	public Double getItemAmount() {
		return itemAmount;
	}

	public void setItemAmount(Double itemAmount) {
		this.itemAmount = itemAmount;
	}

	public Integer getRentId() {
		return rentId;
	}

	public void setRentId(Integer rentId) {
		this.rentId = rentId;
	}

	@Override
	public String toString() {
		return "RentItem{" +
				"itemId=" + itemId +
				", bookName='" + bookName + '\'' +
				", rentFee=" + rentFee +
				", imgPath='" + imgPath + '\'' +
				", returnDate='" + returnDate + '\'' +
				", rentalDay=" + rentalDay +
				", itemAmount=" + itemAmount +
				", rentId=" + rentId +
				'}';
	}
}
