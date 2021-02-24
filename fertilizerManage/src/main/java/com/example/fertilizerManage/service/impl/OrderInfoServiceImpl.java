package com.example.fertilizerManage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fertilizerManage.entity.OrderList;
import com.example.fertilizerManage.mapper.OrderInfoMapper;
import com.example.fertilizerManage.service.OrderInfoService;
@Service
public class OrderInfoServiceImpl implements OrderInfoService{
	
	@Autowired
	private OrderInfoMapper orderInfoMapper;

	@Override
	public void updateOrderList(OrderList orderList) {
		/**
		 * 开始结算 付款金额（pay_price）变为总金额（total_price），拖欠金额为0（owePrice）
		 * 付款状态 0 --》 1
		 */
		orderList.setPayPrice(orderList.getTotalPrice());
		orderList.setOwePrice(0.0);
		orderList.setPayStatus(1);
		orderInfoMapper.updateOrderList(orderList);
	}

}
