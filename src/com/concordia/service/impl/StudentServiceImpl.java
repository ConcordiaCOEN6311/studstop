package com.concordia.service.impl;

import com.concordia.bean.Student;
import com.concordia.dao.StudentDao;
import com.concordia.dao.impl.StudentDaoImpl;
import com.concordia.service.StudentService;
import com.concordia.utils.MD5Util;

/**
 * @Author: Wei Qi
 * @Package: com.concordia.service.impl
 * @Date: 2/20/2022 01:34
 */
public class StudentServiceImpl implements StudentService {
	private StudentDao studentDao = new StudentDaoImpl();
	@Override
	public void doRegister(Student student) throws Exception {
		//verify if user exist
		Student loginStudent = studentDao.findByEmail(student.getEmail());
		if (loginStudent != null){
			throw new RuntimeException("Email already exists, registration failed");
		}

		//encrypt password
		String oldStudentPwd = student.getPassword();
		String encodePwd = MD5Util.encode(oldStudentPwd);
		student.setPassword(encodePwd);
		studentDao.addStudent(student);
	}


	@Override
	public Student doLogin(Student parameterStudent) throws Exception {
		Student loginStudent = studentDao.findByEmail(parameterStudent.getEmail());
		if(loginStudent != null){
			if(MD5Util.encode(parameterStudent.getPassword()).equals(loginStudent.getPassword())){
				return loginStudent;
			}else{
				throw new RuntimeException("Password entered is not correct");
			}
		}
		throw new RuntimeException("Email address entered is not correct");
	}

}
