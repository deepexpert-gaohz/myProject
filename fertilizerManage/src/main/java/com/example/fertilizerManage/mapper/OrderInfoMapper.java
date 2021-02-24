package com.example.fertilizerManage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.fertilizerManage.entity.OrderList;

@Repository
public interface OrderInfoMapper {
	
	//根据条件（姓名，电话，地址，时间）查询
	 List<OrderList> findOrderListByCondition(OrderList orderList);
	 
	 //更新操作
	 void updateOrderList(OrderList orderList);

}
