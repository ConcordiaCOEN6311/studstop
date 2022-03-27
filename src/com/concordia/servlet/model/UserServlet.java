package com.concordia.servlet.model;

import com.concordia.bean.Student;
import com.concordia.service.StudentService;
import com.concordia.service.impl.StudentServiceImpl;
import com.concordia.servlet.base.ModelBaseServlet;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.*;
import java.io.IOException;
import java.util.Map;

public class UserServlet extends ModelBaseServlet {
	private StudentService studentService = new StudentServiceImpl();

	public void toLoginPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		processTemplate("user/login",request,response);
	}

	public void toRegisterPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		processTemplate("user/register",request,response);
	}

	public void doLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Map<String, String[]> parameterMap = request.getParameterMap();
		Student student = new Student();
		try {
			BeanUtils.populate(student, parameterMap);
			studentService.doLogin(student);
			response.sendRedirect(request.getContextPath() + "/index.html");
		} catch (Exception e) {
			e.printStackTrace();
			//response.getWriter().write("login failed,"+e.getMessage());
			response.sendRedirect(request.getContextPath() + "/user?method=toLoginPage");
		}
	}
	public void doRegister(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Map<String, String[]> parameterMap = request.getParameterMap();
		Student student = new Student();
		try {
			BeanUtils.populate(student,parameterMap);
			studentService.doRegister(student);
			response.sendRedirect(request.getContextPath() + "/index");
			//response.getWriter().write("Register success");
		} catch (Exception e) {
			e.printStackTrace();
			//response.getWriter().write("Register Failed," + e.getMessage());
			response.sendRedirect(request.getContextPath() + "/user?method=toRegisterPage");
		}
	}
}
