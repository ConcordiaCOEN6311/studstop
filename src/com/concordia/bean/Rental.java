package com.concordia.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: Wei Qi
 * @Package: com.concordia.bean
 * @Date: 4/24/2022 23:14
 */
public class Rental {
	private Integer rentId;
	private String rentSequence;
	private String createTime;
	private Integer totalCount;
	private Double totalAmount;
	private String appointmentTime;
	private String appointmentDate;
	private Integer userId;

	public Rental() {
	}

	public Rental(Integer rentId, String rentSequence, String createTime, Integer totalCount, Double totalAmount, String appointmentTime, String appointmentDate, String returnDate, Integer userId) {
		this.rentId = rentId;
		this.rentSequence = rentSequence;
		this.createTime = createTime;
		this.totalCount = totalCount;
		this.totalAmount = totalAmount;
		this.appointmentTime = appointmentTime;
		this.appointmentDate = appointmentDate;
		this.userId = userId;
	}

	public Integer getRentId() {
		return rentId;
	}

	public void setRentId(Integer rentId) {
		this.rentId = rentId;
	}

	public String getRentSequence() {
		return rentSequence;
	}

	public void setRentSequence(String rentSequence) {
		this.rentSequence = rentSequence;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(String appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

	public String getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Rental{" +
				"rentId=" + rentId +
				", rentSequence='" + rentSequence + '\'' +
				", createTime='" + createTime + '\'' +
				", totalCount=" + totalCount +
				", totalAmount=" + totalAmount +
				", appointmentTime='" + appointmentTime + '\'' +
				", appointmentDate='" + appointmentDate + '\'' +
				", userId=" + userId +
				'}';
	}
}
