package com.bean;


public class Page {
	private int totalItems;
	private int totalPages;
	private int pageItems;
	private int curPage;
	private int firstPage;
	public int getTotalItems() {
		return totalItems;
	}
	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getPageItems() {
		return pageItems;
	}
	public void setPageItems(int pageItems) {
		this.pageItems = pageItems;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getFirstPage() {
		return firstPage;
	}
	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}
}
