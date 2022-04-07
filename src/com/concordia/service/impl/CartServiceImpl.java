package com.concordia.service.impl;

import com.concordia.dao.CartDao;
import com.concordia.dao.impl.CartDaoImpl;
import com.concordia.service.CartService;

import java.util.List;

/**
 * @Author: Wei Qi
 * @Package: com.concordia.service.impl
 * @Date: 4/6/2022 18:17
 */
public class CartServiceImpl implements CartService {
	private CartDao cartDao = new CartDaoImpl();
	@Override
	public List<String> showAppointmentDate() throws Exception {
		return cartDao.getAppointmentDateList();
	}
}
