package com.concordia.dao;

import com.concordia.bean.Student;

import java.sql.SQLException;

public interface StudentDao {

	Student findByEmail(String email) throws SQLException;

	void addStudent(Student user) throws SQLException;
}
