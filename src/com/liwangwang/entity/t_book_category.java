package com.liwangwang.entity;

public class t_book_category {
	
	private int book_category_id;
	private String book_category_name;
	public int getBook_category_id() {
		return book_category_id;
	}
	public void setBook_category_id(int book_category_id) {
		this.book_category_id = book_category_id;
	}
	public String getBook_category_name() {
		return book_category_name;
	}
	public void setBook_category_name(String book_category_name) {
		this.book_category_name = book_category_name;
	}
	public t_book_category(String book_category_name) {
		super();
		this.book_category_name = book_category_name;
	}
	public t_book_category() {
		super();
	}
	
	

}
