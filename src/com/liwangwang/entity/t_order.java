package com.liwangwang.entity;

public class t_order {
	private int order_id;
	private int user_id;
	private String order_datetime;
	private String consignee;
	private String phone;
	private String postalcode;
	private String address;
	private int send_type;
	private String send_datetime;
	private float order_price;
	private int order_state;
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getOrder_datetime() {
		return order_datetime;
	}
	public void setOrder_datetime(String order_datetime) {
		this.order_datetime = order_datetime;
	}
	public String getConsignee() {
		return consignee;
	}
	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPostalcode() {
		return postalcode;
	}
	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getSend_type() {
		return send_type;
	}
	public void setSend_type(int send_type) {
		this.send_type = send_type;
	}
	public String getSend_datetime() {
		return send_datetime;
	}
	public void setSend_datetime(String send_datetime) {
		this.send_datetime = send_datetime;
	}
	public float getOrder_price() {
		return order_price;
	}
	public void setOrder_price(float order_price) {
		this.order_price = order_price;
	}
	public int getOrder_state() {
		return order_state;
	}
	public void setOrder_state(int order_state) {
		this.order_state = order_state;
	}
	public t_order(int order_id, int user_id, String order_datetime, String consignee, String phone, String postalcode,
			String address, int send_type, String send_datetime, float order_price, int order_state) {
		super();
		this.order_id = order_id;
		this.user_id = user_id;
		this.order_datetime = order_datetime;
		this.consignee = consignee;
		this.phone = phone;
		this.postalcode = postalcode;
		this.address = address;
		this.send_type = send_type;
		this.send_datetime = send_datetime;
		this.order_price = order_price;
		this.order_state = order_state;
	}
	public t_order() {
		super();
	}
	
	

}
