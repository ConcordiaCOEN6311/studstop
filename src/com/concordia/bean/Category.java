package com.concordia.bean;

/**
 * @Author: Wei Qi
 * @Package: com.concordia.bean
 * @Date: 3/27/2022 01:43
 */
public class Category {
	private Integer categoryId;
	private String categoryName;

	public Category() {
	}

	public Category(Integer categoryId, String categoryName) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "Category{" +
				"categoryId=" + categoryId +
				", categoryName='" + categoryName + '\'' +
				'}';
	}
}
