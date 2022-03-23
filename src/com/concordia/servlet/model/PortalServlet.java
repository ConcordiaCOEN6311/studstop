package com.concordia.servlet.model;

import com.concordia.servlet.base.ModelBaseServlet;
import com.concordia.servlet.base.ViewBaseServlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class PortalServlet extends ModelBaseServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processTemplate("index",request,response);
	}
}
