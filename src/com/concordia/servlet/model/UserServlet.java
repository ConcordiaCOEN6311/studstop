package com.concordia.servlet.model;

import com.concordia.bean.Student;
import com.concordia.constant.MyConstants;
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
			Student loginUser = studentService.doLogin(student);
			request.getSession().setAttribute(MyConstants.USER_SESSION_KEY,loginUser);
			processTemplate("index",request,response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Login Failed," + e.getMessage());
			processTemplate("user/login",request,response);
		}
	}
	public void doRegister(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Map<String, String[]> parameterMap = request.getParameterMap();
		String code = parameterMap.get("code")[0];
		String checkCode = (String) request.getSession().getAttribute("KAPTCHA_SESSION_KEY");
		if (checkCode.equalsIgnoreCase(code)) {
		Student student = new Student();
		try {
			BeanUtils.populate(student,parameterMap);
			Student loginUser = studentService.doRegister(student);
			request.getSession().setAttribute(MyConstants.USER_SESSION_KEY,loginUser);
			processTemplate("index",request,response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage","Register Failed:" + e.getMessage());
			processTemplate("user/register",request,response);
		}
		}else {
			request.setAttribute("errorMessage","Register Failed: incorrect check code");
			processTemplate("user/register",request,response);
		}
	}

	public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.getSession().invalidate();
		response.sendRedirect(request.getContextPath() + "/index.html");
	}
}
