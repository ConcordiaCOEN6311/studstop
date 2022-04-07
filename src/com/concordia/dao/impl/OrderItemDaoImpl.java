package com.concordia.dao.impl;

import com.concordia.bean.OrderItem;
import com.concordia.dao.BaseDao;
import com.concordia.dao.OrderItemDao;

/**
 * @Author: Wei Qi
 * @Package: com.concordia.service.impl
 * @Date: 4/7/2022 02:06
 */
public class OrderItemDaoImpl extends BaseDao<OrderItem> implements OrderItemDao {
	@Override
	public void insertOrderItems(Object[][] orderItems) {
		String sql = "insert into order_item (book_name,price,img_path,item_count,item_amount,order_id) values(?,?,?,?,?,?)";
		batchUpdate(sql,orderItems);
	}
}
