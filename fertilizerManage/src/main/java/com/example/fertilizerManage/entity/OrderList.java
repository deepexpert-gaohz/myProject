package com.example.fertilizerManage.entity;

import java.io.Serializable;
import java.util.Date;

public class OrderList {


	
	private String id;
	
	private String buyerName;
	
	private String tel;
	
	private String address;
	
	private String variety;  //化肥品种
	
	private Double unitPrice; //单价 （元/斤）
	
	private Double count;   //数量 （斤）
	
	private Double totalPrice;
	
	private Double payPrice;
	
	private Double owePrice;
	
	private String date;
	
	private int pageSize;
	
	private int pageNo;
	
	private int payStatus;
	
	
	

	public int getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(int payStatus) {
		this.payStatus = payStatus;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getVariety() {
		return variety;
	}

	public void setVariety(String variety) {
		this.variety = variety;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Double getCount() {
		return count;
	}

	public void setCount(Double count) {
		this.count = count;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Double getPayPrice() {
		return payPrice;
	}

	public void setPayPrice(Double payPrice) {
		this.payPrice = payPrice;
	}

	public Double getOwePrice() {
		return owePrice;
	}

	public void setOwePrice(Double owePrice) {
		this.owePrice = owePrice;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderList [id=");
		builder.append(id);
		builder.append(", buyerName=");
		builder.append(buyerName);
		builder.append(", tel=");
		builder.append(tel);
		builder.append(", address=");
		builder.append(address);
		builder.append(", variety=");
		builder.append(variety);
		builder.append(", unitPrice=");
		builder.append(unitPrice);
		builder.append(", count=");
		builder.append(count);
		builder.append(", totalPrice=");
		builder.append(totalPrice);
		builder.append(", payPrice=");
		builder.append(payPrice);
		builder.append(", owePrice=");
		builder.append(owePrice);
		builder.append(", date=");
		builder.append(date);
		builder.append(", pageSize=");
		builder.append(pageSize);
		builder.append(", pageNo=");
		builder.append(pageNo);
		builder.append(", payStatus=");
		builder.append(payStatus);
		builder.append("]");
		return builder.toString();
	}


	
	

}
