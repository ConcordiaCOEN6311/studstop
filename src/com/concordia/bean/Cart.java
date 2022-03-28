package com.concordia.bean;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author: Wei Qi
 * @Date: 3/26/2022 05:20
 */
public class Cart {
	private Map<Integer,CartItem> cartItemMap = new HashMap<>();

	@Override
	public String toString() {
		return "Cart{" +
				"cartItemMap=" + cartItemMap +
				'}';
	}

	public void addBookToCart(Book book) throws ParseException {
		if (cartItemMap.containsKey(book.getBookId())) {
			//not first time to add book to cart
			itemCountIncrease(book.getBookId());
		}else {
			//fist time to add book to cart, count = 1
			CartItem cartItem = new CartItem(book.getBookId(),book.getBookName(),book.getImgPath(),book.getFinalPrice(), 1, book.getFinalPrice());
			cartItemMap.put(cartItem.getBookId(),cartItem);
		}
	}

	public Map<Integer,CartItem> getCartItemMap(){
		return cartItemMap;
	}

	public void itemCountIncrease(Integer bookId){
		CartItem cartItem = cartItemMap.get(bookId);
		cartItem.countIncrease();
	}


	public void itemCountDecrease(Integer bookId){
		CartItem cartItem = cartItemMap.get(bookId);
		cartItem.countDecrease();
		if (cartItem.getCount() == 0) {
			//remove item from cart
			removeCartItem(bookId);
		}
	}

	//remove item
	public void removeCartItem(Integer bookId){
		cartItemMap.remove(bookId);
	}

	//update count of item
	public void updateItemCount(Integer bookId, Integer newCount){
		CartItem cartItem = cartItemMap.get(bookId);
		cartItem.setCount(newCount);
	}

	public Integer getTotalCount(){
		Integer totalCount = 0;
		Set<Map.Entry<Integer, CartItem>> entries = cartItemMap.entrySet();
		for (Map.Entry<Integer, CartItem> entry : entries) {
			totalCount += entry.getValue().getCount();
		}
		return totalCount;
	}

	public Double getTotalAmount(){
		Double totalAmount = 0.0;
		Set<Map.Entry<Integer, CartItem>> entries = cartItemMap.entrySet();
		for (Map.Entry<Integer, CartItem> entry : entries) {
			totalAmount += entry.getValue().getAmount();
		}
		return totalAmount;
	}
}




















