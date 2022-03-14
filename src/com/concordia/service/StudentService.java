package com.concordia.service;


import com.concordia.bean.Student;

public interface StudentService {
	/**
	 * @Author Wei Qi
	 * @Description register interface
	 * @Date 2/20/2022 5:28 PM
	 * @Param [student]
	 * @return void
	 */
	void doRegister(Student student) throws Exception;

	/**
	 * @Author Wei Qi
	 * @Description login interface
	 * @Date 2/20/2022 5:29 PM
	 * @Param [parameterStudent]
	 * @return com.concordia.bean.Student
	 */
	Student doLogin(Student parameterStudent) throws Exception;

}
