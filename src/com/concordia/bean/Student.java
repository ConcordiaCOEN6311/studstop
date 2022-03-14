package com.concordia.bean;

/**
 * @Author: Wei Qi
 * @Package: com.concordia.bean
 * @Date: 2/20/2022 16:57
 */
public class Student {
	private Integer studentId;
	private String firstname;
	private String lastname;
	private String password;
	private String email;
	private String phoneNo;

	public Student() {
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Override
	public String toString() {
		return "Student{" +
				"studentId=" + studentId +
				", firstname='" + firstname + '\'' +
				", lastname='" + lastname + '\'' +
				", password='" + password + '\'' +
				", email='" + email + '\'' +
				", phoneNo='" + phoneNo + '\'' +
				'}';
	}
}
