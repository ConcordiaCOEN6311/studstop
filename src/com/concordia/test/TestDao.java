package com.concordia.test;

import com.concordia.constant.UUID22;
import com.concordia.dao.CartDao;
import com.concordia.dao.impl.CartDaoImpl;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: Wei Qi
 * @Package: com.concordia.test
 * @Date: 4/6/2022 17:21
 */
public class TestDao {
	@Test
	public void testFindAptTimeList() throws SQLException {
		CartDao cartDao = new CartDaoImpl();
		List appointmentDateList = cartDao.getAppointmentDateList();
		System.out.println(appointmentDateList.toString());
		for (Object o : appointmentDateList) {
			System.out.println(o);
		}
	}

	@Test
	public void testUUID(){
		String s = UUID22.generateShortUuid();
		System.out.println(s);
	}
}
