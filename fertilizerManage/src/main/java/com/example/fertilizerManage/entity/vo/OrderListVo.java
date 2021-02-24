package com.example.fertilizerManage.entity.vo;

import java.util.List;

import com.example.fertilizerManage.entity.OrderList;

public class OrderListVo {
	
	private List<OrderList> list;

	public List<OrderList> getList() {
		return list;
	}

	public void setList(List<OrderList> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderListVo [list=");
		builder.append(list);
		builder.append("]");
		return builder.toString();
	}
	
	

}
