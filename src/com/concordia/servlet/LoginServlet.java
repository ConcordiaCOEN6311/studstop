package com.concordia.servlet;

import com.concordia.bean.Student;
import com.concordia.service.StudentService;
import com.concordia.service.impl.StudentServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class LoginServlet extends HttpServlet {
	private StudentService studentService = new StudentServiceImpl();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String[]> parameterMap = request.getParameterMap();
		Student student = new Student();
		try {
			BeanUtils.populate(student, parameterMap);
			studentService.doLogin(student);
			//response.sendRedirect(request.getContextPath() + "/pages/user/login_success.html");
			response.getWriter().write("Welcome back!");
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().write("login failed,"+e.getMessage());
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}
