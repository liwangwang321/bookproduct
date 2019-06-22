package com.liwangwang.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeNode {
	private String id;
	private String text;
	private String iconCls;
	private boolean checked;
	
	private List<TreeNode> children = new ArrayList<>();
	private Map<String, Object> attributes = new  HashMap<String, Object>();
	
	
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public List<TreeNode> getChildren() {
		return children;
	}
	public void setChildren(List<TreeNode> children) {
		this.children = children;
	}
	public Map<String, Object> getAttributes() {
		return attributes;
	}
	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}
	@Override
	public String toString() {
		return "TreeNode [id=" + id + ", text=" + text + ", iconCls=" + iconCls + ", checked=" + checked + ", children="
				+ children + ", attributes=" + attributes + "]";
	}
	
	

}
