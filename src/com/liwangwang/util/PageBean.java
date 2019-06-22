package com.liwangwang.util;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * 分页工具类
 *
 */
public class PageBean {

	private int page = 1;// 页码

	private int rows = 10;// 页大小

	private int total = 0;// 总记录数

	private boolean pagination = true;// 是否分页
	// 获取前台向后台提交的所有参数
	private Map<String, String[]> parameterMap;
	// 获取上一次访问后台的url
	private String url;

	/**
	 * 初始化pagebean
	 * 
	 * @param req
	 */
	public void setRequest(HttpServletRequest req) {
		this.setPage(req.getParameter("page"));
		this.setRows(req.getParameter("rows"));
		// 只有jsp页面上填写pagination=false才是不分页
		this.setPagination(!"fasle".equals(req.getParameter("pagination")));
		this.setParameterMap(req.getParameterMap());
		this.setUrl(req.getRequestURL().toString());
	}

	public int getMaxPage() {
		return this.total % this.rows == 0 ? this.total / this.rows : this.total / this.rows + 1;
	}

	public int nextPage() {
		return this.page < this.getMaxPage() ? this.page + 1 : this.getMaxPage();
	}

	public int previousPage() {
		return this.page > 1 ? this.page - 1 : 1;
	}

	public PageBean() {
		super();
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public void setPage(String page) {
		this.page = StringUtils.isBlank(page) ? this.page : Integer.valueOf(page);
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public void setRows(String rows) {
		this.rows = StringUtils.isBlank(rows) ? this.rows : Integer.valueOf(rows);
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public void setTotal(String total) {
		this.total = Integer.parseInt(total);
	}

	public boolean isPagination() {
		return pagination;
	}

	public void setPagination(boolean pagination) {
		this.pagination = pagination;
	}

	public Map<String, String[]> getParameterMap() {
		return parameterMap;
	}

	public void setParameterMap(Map<String, String[]> parameterMap) {
		this.parameterMap = parameterMap;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * 获得起始记录的下标
	 * 
	 * @return
	 */
	public int getStartIndex() {
		return (this.page - 1) * this.rows;
	}

	@Override
	public String toString() {
		return "PageBean [page=" + page + ", rows=" + rows + ", total=" + total + ", pagination=" + pagination
				+ ", parameterMap=" + parameterMap + ", url=" + url + "]";
	}

}
