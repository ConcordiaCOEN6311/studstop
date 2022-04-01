package com.concordia.bean;

import java.util.Date;

public class RentalItem {

    private Integer rentalId;
    private Integer bookId;
    private String bookName;
    private Integer studentId;
    private Date appointmentDate;
    private Date returnDate;
    private Double rentalFee;
    private Date createdDate;
    private String imgPath;
    private Integer count;
    private Double amount;

    public RentalItem(Integer rentalId, Integer bookId, String bookName, Integer studentId, Date appointmentDate, Date returnDate, Double rentalFee, Date createdDate, String imgPath, Integer count, Double amount) {
        this.rentalId = rentalId;
        this.bookId = bookId;
        this.bookName = bookName;
        this.studentId = studentId;
        this.appointmentDate = appointmentDate;
        this.returnDate = returnDate;
        this.rentalFee = rentalFee;
        this.createdDate = createdDate;
        this.imgPath = imgPath;
        this.count = count;
        this.amount = amount;
    }

    public Integer getRentalId() {
        return rentalId;
    }

    public void setRentalId(Integer rentalId) {
        this.rentalId = rentalId;
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

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Double getRentalFee() {
        return rentalFee;
    }

    public void setRentalFee(Double rentalFee) {
        this.rentalFee = rentalFee;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void countIncrease() { this.count++; }

    public void countDecrease(){
        this.count--;
    }

    @Override
    public String toString() {
        return "RentalItem{" +
                "rentalId=" + rentalId +
                ", bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", studentId=" + studentId +
                ", appointmentDate=" + appointmentDate +
                ", returnDate=" + returnDate +
                ", rentalFee=" + rentalFee +
                ", createdDate=" + createdDate +
                ", imgPath='" + imgPath + '\'' +
                ", count=" + count +
                ", amount=" + amount +
                '}';
    }
}
