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

/**
 * @Author Wei Qi
 * @Description Register Servlet
 * @Date 2/20/2022 5:28 PM
 */
public class RegisterServlet extends HttpServlet {
    private StudentService studentService = new StudentServiceImpl();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        Student student = new Student();
        try {
            BeanUtils.populate(student,parameterMap);
			studentService.doRegister(student);
			//response.sendRedirect(request.getContextPath() + "/pages/user/register_success.html");
			response.getWriter().write("Register success");
        } catch (Exception e) {
            e.printStackTrace();
			response.getWriter().write("Register Failed," + e.getMessage());
        }
    }
}
