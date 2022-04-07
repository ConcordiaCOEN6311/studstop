package com.concordia.dao;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: Wei Qi
 * @Package: com.concordia.dao
 * @Date: 4/6/2022 17:11
 */
public interface CartDao {
	List<String> getAppointmentDateList() throws SQLException;
}
