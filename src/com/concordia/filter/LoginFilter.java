package com.concordia.filter;

import com.concordia.bean.Student;
import com.concordia.constant.MyConstants;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
	public void init(FilterConfig config) throws ServletException {
	}

	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		HttpSession session = request.getSession();
		Student loginUser = (Student) session.getAttribute(MyConstants.USER_SESSION_KEY);
		if(loginUser == null){
			request.setAttribute("errorMessage", "Please login first");
			request.getRequestDispatcher("/user?method=toLoginPage").forward(request,response);
			return;
		}
		chain.doFilter(req, res);
	}
}
