package com.concordia.bean;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RentalCart {
    private Map<Integer,RentalCartItem> rentalCartItemMap = new HashMap<>();
    private String appointmentTime;
    private String appointmentDate;

    @Override
    public String toString() {
        return "RentalCart{" +
                "rentalCartItemMap=" + rentalCartItemMap +
                ", appointmentTime='" + appointmentTime + '\'' +
                ", appointmentDate=" + appointmentDate +
                '}';
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

    public Boolean addBookToRentalCart(Book book) throws ParseException {
        if (rentalCartItemMap.containsKey(book.getBookId())) {
            //not first time to add book to cart
            return true;
        }else {
            //fist time to add book to cart, count = 1
            RentalCartItem rentalCartItem = new RentalCartItem(book.getBookId(),book.getBookName(),book.getImgPath(),book.getRentPrice(),3, 1, book.getRentPrice()*3);
            rentalCartItemMap.put(rentalCartItem.getBookId(),rentalCartItem);
            return false;
        }
    }

    public Map<Integer,RentalCartItem> getRentalCartItemMap(){
        return rentalCartItemMap;
    }

    //remove item
    public void removeRentalCartItem(Integer bookId){
        rentalCartItemMap.remove(bookId);
    }

    public void itemCountIncrease(Integer bookId){
        RentalCartItem rentalCartItem = rentalCartItemMap.get(bookId);
        rentalCartItem.countIncrease();
    }


    public void itemCountDecrease(Integer bookId){
        RentalCartItem rentalCartItem = rentalCartItemMap.get(bookId);
        rentalCartItem.countDecrease();
        if (rentalCartItem.getCount() == 0) {
            //remove item from cart
            removeRentalCartItem(bookId);
        }
    }


    public void updateItemRentalDays(Integer bookId, Integer newCount){
        RentalCartItem rentalCartItem = rentalCartItemMap.get(bookId);
        rentalCartItem.setRentalDays(newCount);
    }

    public Integer getTotalCount(){
        Integer totalCount = 0;
        Set<Map.Entry<Integer, RentalCartItem>> entries = rentalCartItemMap.entrySet();
        for (Map.Entry<Integer, RentalCartItem> entry : entries) {
            totalCount += entry.getValue().getCount();
        }
        return totalCount;
    }

    public Double getTotalAmount(){
        Double totalAmount = 0.0;
        Set<Map.Entry<Integer, RentalCartItem>> entries = rentalCartItemMap.entrySet();
        for (Map.Entry<Integer, RentalCartItem> entry : entries) {
            totalAmount += entry.getValue().getAmount();
        }
        String  str = String.format("%.2f",totalAmount);
        Double finalTotalAmount = Double.parseDouble(str);
        return finalTotalAmount;
    }
}
