package com.concordia.bean;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RentalCart {
    private Map<Integer,RentalItem> rentalCartItemMap = new HashMap<>();


    public void addRentalBookToCart(Book book, RentalItem rentalItem) throws ParseException {
        if (rentalCartItemMap.containsKey(book.getBookId())) {
            //not first time to add book to cart
            itemCountIncrease(book.getBookId());
        }else {
            //fist time to add book to cart, count = 1
            RentalItem rentalCartItem = new RentalItem(rentalItem.getRentalId(), book.getBookId(),book.getBookName(),rentalItem.getStudentId(),rentalItem.getAppointmentDate(), rentalItem.getReturnDate(), rentalItem.getRentalFee(), rentalItem.getCreatedDate(), book.getImgPath(),1, book.getFinalPrice());
            rentalCartItemMap.put(rentalCartItem.getBookId(),rentalCartItem);
        }
    }

    public Map<Integer,RentalItem> getRentalCartItemMap(){
        return rentalCartItemMap;
    }

    public void itemCountIncrease(Integer bookId){
        RentalItem rentalCartItem = rentalCartItemMap.get(bookId);
        rentalCartItem.countIncrease();
    }


    public void itemCountDecrease(Integer bookId){
        RentalItem rentalCartItem = rentalCartItemMap.get(bookId);
        rentalCartItem.countDecrease();
        if (rentalCartItem.getCount() == 0) {
            removeCartItem(bookId);
        }
    }

    //remove item
    public void removeCartItem(Integer bookId){
        rentalCartItemMap.remove(bookId);
    }

    //update count of item
    public void updateItemCount(Integer bookId, Integer newCount){
        RentalItem rentalCartItem = rentalCartItemMap.get(bookId);
        rentalCartItem.setCount(newCount);
    }

    public Integer getTotalCount(){
        Integer totalCount = 0;
        Set<Map.Entry<Integer, RentalItem>> entries = rentalCartItemMap.entrySet();
        for (Map.Entry<Integer, RentalItem> entry : entries) {
            totalCount += entry.getValue().getCount();
        }
        return totalCount;
    }

    public Double getTotalAmount(){
        Double totalAmount = 0.0;
        Set<Map.Entry<Integer, RentalItem>> entries = rentalCartItemMap.entrySet();
        for (Map.Entry<Integer, RentalItem> entry : entries) {
            totalAmount += entry.getValue().getAmount();
        }
        return totalAmount;
    }
}
