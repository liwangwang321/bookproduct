package com.liwangwang.entity;

public class t_order_item {
	
	private int order_item_id;
	private int order_id;
	private int book_id;
	private int quantity;
	public int getOrder_item_id() {
		return order_item_id;
	}
	public void setOrder_item_id(int order_item_id) {
		this.order_item_id = order_item_id;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public t_order_item(int order_item_id, int order_id, int book_id, int quantity) {
		super();
		this.order_item_id = order_item_id;
		this.order_id = order_id;
		this.book_id = book_id;
		this.quantity = quantity;
	}
	public t_order_item(int order_id, int book_id, int quantity) {
		super();
		this.order_id = order_id;
		this.book_id = book_id;
		this.quantity = quantity;
	}
	public t_order_item() {
		super();
	}
	
	

}
