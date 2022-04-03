package com.concordia.servlet.model;

import com.concordia.bean.Book;
import com.concordia.bean.RentalCart;
import com.concordia.service.BookService;
import com.concordia.service.impl.BookServiceImpl;
import com.concordia.servlet.base.ModelBaseServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RentalServlet extends ModelBaseServlet {

    private BookService bookService = new BookServiceImpl();
    public void addRentalItemToCart(HttpServletRequest request, HttpServletResponse response){

    }

    public void toRentalCartPage(HttpServletRequest request,HttpServletResponse response) throws IOException {
        processTemplate("rentalCart/cart",request,response);
    }
}
