package com.concordia.dao.impl;

import com.concordia.bean.RentItem;
import com.concordia.dao.BaseDao;
import com.concordia.dao.RentOrderItemDao;

/**
 * @Author: Wei Qi
 * @Package: com.concordia.dao.impl
 * @Date: 4/25/2022 00:31
 */
public class RentOrderItemDaoImpl extends BaseDao<RentItem> implements RentOrderItemDao {
	@Override
	public void insertRentOrderItem(Object[][] orderItems) {
		String sql = "insert into rent_item (book_name,rent_fee,img_path,return_date,rental_day,item_amount,rent_id) values(?,?,?,?,?,?,?)";
		batchUpdate(sql,orderItems);
	}
}
