package com.concordia.dao.impl;

import com.concordia.dao.BaseDao;
import com.concordia.dao.CartDao;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: Wei Qi
 * @Package: com.concordia.dao.impl
 * @Date: 4/6/2022 17:14
 */
public class CartDaoImpl extends BaseDao implements CartDao {

	@Override
	public List<String> getAppointmentDateList() throws SQLException {
		String sql = "select appointment_time from apt_time_mgt";
		return getStringList(sql);
	}
}
