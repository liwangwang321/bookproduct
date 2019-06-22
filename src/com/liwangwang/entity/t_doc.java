package com.liwangwang.entity;

public class t_doc {
	private int id;
	private String file_name;
	private String mime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public String getMime() {
		return mime;
	}
	public void setMime(String mime) {
		this.mime = mime;
	}
	public t_doc(int id, String file_name, String mime) {
		super();
		this.id = id;
		this.file_name = file_name;
		this.mime = mime;
	}
	public t_doc() {
		super();
	}
	

}
