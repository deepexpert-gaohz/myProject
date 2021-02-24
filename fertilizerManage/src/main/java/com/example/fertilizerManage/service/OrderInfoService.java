package com.example.fertilizerManage.service;

import com.example.fertilizerManage.entity.OrderList;

public interface OrderInfoService {
  
	/*
	 * 结算当前订单
	 */
	void updateOrderList(OrderList orderList);
}
