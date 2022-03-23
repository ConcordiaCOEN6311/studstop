package com.concordia.dao.impl;

import com.concordia.bean.Student;
import com.concordia.dao.BaseDao;
import com.concordia.dao.StudentDao;

import java.sql.SQLException;

/**
 * @Author: Wei Qi
 * @Package: com.concordia.dao
 * @Date: 2/19/2022 20:36
 */
public class StudentDaoImpl extends BaseDao implements StudentDao {

	@Override
	public Student findByEmail(String email) throws SQLException {
		String sql = "select s_id as studentId, s_firstname as firstname, s_lastname as lastname, s_password as password, s_email as email, s_phoneno as phoneNo from student_user where s_email=?";
		return (Student) getBean(Student.class, sql, email);
	}

	@Override
	public void addStudent(Student student) throws SQLException {
		String sql = "insert into student_user(s_firstname,s_lastname,s_password,s_email,s_phoneno) values(?,?,?,?,?)";
		update(sql, student.getFirstname(), student.getLastname(), student.getPassword(), student.getEmail(), student.getPhoneNo());
	}
}
