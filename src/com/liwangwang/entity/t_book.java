package com.liwangwang.entity;


public class t_book {
	
	
	private int book_id;
	private String book_name;
	private String book_name_pinyin;
	private int book_category_id;
	private String book_author;
	private float book_price;
	private String book_image;
	private String publishing;
	private String book_desc;
	private int book_state;
	private String deploy_datetime;
	private int sales_volume;
	
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getBook_name_pinyin() {
		return book_name_pinyin;
	}
	public void setBook_name_pinyin(String book_name_pinyin) {
		this.book_name_pinyin = book_name_pinyin;
	}
	public int getBook_category_id() {
		return book_category_id;
	}
	public void setBook_category_id(int book_category_id) {
		this.book_category_id = book_category_id;
	}
	public String getBook_author() {
		return book_author;
	}
	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}
	public float getBook_price() {
		return book_price;
	}
	public void setBook_price(float book_price) {
		this.book_price = book_price;
	}
	
	public String getBook_image() {
		return book_image;
	}
	public void setBook_image(String book_image) {
		this.book_image = book_image;
	}
	public String getPublishing() {
		return publishing;
	}
	public void setPublishing(String publishing) {
		this.publishing = publishing;
	}
	public String getBook_desc() {
		return book_desc;
	}
	public void setBook_desc(String book_desc) {
		this.book_desc = book_desc;
	}
	public int getBook_state() {
		return book_state;
	}
	public void setBook_state(int book_state) {
		this.book_state = book_state;
	}
	public String getDeploy_datetime() {
		return deploy_datetime;
	}
	public void setDeploy_datetime(String deploy_datetime) {
		this.deploy_datetime = deploy_datetime;
	}
	public int getSales_volume() {
		return sales_volume;
	}
	public void setSales_volume(int sales_volume) {
		this.sales_volume = sales_volume;
	}
	
	public t_book(int book_id, String book_name, String book_name_pinyin, int book_category_id, String book_author,
			float book_price, String book_image, String publishing, String book_desc, int book_state,
			String deploy_datetime, int sales_volume) {
		super();
		this.book_id = book_id;
		this.book_name = book_name;
		this.book_name_pinyin = book_name_pinyin;
		this.book_category_id = book_category_id;
		this.book_author = book_author;
		this.book_price = book_price;
		this.book_image = book_image;
		this.publishing = publishing;
		this.book_desc = book_desc;
		this.book_state = book_state;
		this.deploy_datetime = deploy_datetime;
		this.sales_volume = sales_volume;
	}
	
	public t_book(String book_name, String book_name_pinyin, int book_category_id, String book_author, float book_price,
			String book_image, String publishing, String book_desc, int book_state, String deploy_datetime,
			int sales_volume) {
		super();
		this.book_name = book_name;
		this.book_name_pinyin = book_name_pinyin;
		this.book_category_id = book_category_id;
		this.book_author = book_author;
		this.book_price = book_price;
		this.book_image = book_image;
		this.publishing = publishing;
		this.book_desc = book_desc;
		this.book_state = book_state;
		this.deploy_datetime = deploy_datetime;
		this.sales_volume = sales_volume;
	}
	public t_book() {
		super();
	}
	@Override
	public String toString() {
		return "t_book [book_id=" + book_id + ", book_name=" + book_name + ", book_name_pinyin=" + book_name_pinyin
				+ ", book_category_id=" + book_category_id + ", book_author=" + book_author + ", book_price="
				+ book_price + ", book_image=" + book_image + ", publishing=" + publishing + ", book_desc=" + book_desc
				+ ", book_state=" + book_state + ", deploy_datetime=" + deploy_datetime + ", sales_volume="
				+ sales_volume + "]";
	}
	
	
	

}
