package com.concordia.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Wei Qi
 * @Date: 3/25/2022 04:26
 */
public class Page<T> {
	private List<T> infoList = new ArrayList<>();
	private int currentPage; // Current page
	private int currentCount; // Display count for each page
	private int totalPage; // total page
	private int totalCount; // total records

	public Page() {
	}

	public Page(List<T> infoList, int currentPage, int currentCount, int totalPage, int totalCount) {
		this.infoList = infoList;
		this.currentPage = currentPage;
		this.currentCount = currentCount;
		this.totalPage = totalPage;
		this.totalCount = totalCount;
	}

	public List<T> getInfoList() {
		return infoList;
	}

	public void setInfoList(List<T> infoList) {
		this.infoList = infoList;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getCurrentCount() {
		return currentCount;
	}

	public void setCurrentCount(int currentCount) {
		this.currentCount = currentCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
}
