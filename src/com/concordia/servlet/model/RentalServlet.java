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
        Integer id = Integer.valueOf(request.getParameter("id"));
        String view = request.getParameter("view");
        String catId = request.getParameter("catId");
        String currentPage = request.getParameter("currentPage");
        String catName = request.getParameter("catName");
        try {
            Book book = bookService.findBookById(id);
            HttpSession session = request.getSession();
            RentalCart rentalCart = (RentalCart) session.getAttribute("RentalCart");
            if(rentalCart == null){
                rentalCart = new RentalCart();
                rentalCart.addRentalBookToCart(book, null);
                session.setAttribute("RentalCart", rentalCart);
            }else {
                rentalCart.addRentalBookToCart(book, null);
            }

            if("grid".equals(view)){
                response.sendRedirect(request.getContextPath() + "/book?method=toShopGridPageByCatId&currentPage="+currentPage+"&catId="+catId+"&catName="+catName);
            }
            if("list".equals(view)){
                response.sendRedirect(request.getContextPath() + "/book?method=toShopListPageByCatId&currentPage="+currentPage+"&catId="+catId+"&catName="+catName);
            }
//			response.sendRedirect(request.getContextPath() + "/index.html");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void toRentalCartPage(HttpServletRequest request,HttpServletResponse response) throws IOException {
        processTemplate("rentalCart/cart",request,response);
    }
}
