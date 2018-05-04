package com.model2.mvc.common;


public class Search {
	
	///Field
	private int curruntPage;
	private String searchCondition;
	private String searchKeyword;
	private int pageSize;
	private int priceUpDown;
	private int rowNum;
	private int between1;
	private int between2;
	
	
	///Constructor
	public Search() {
	}
	
	///Method
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int paseSize) {
		this.pageSize = paseSize;
	}
	
	public int getCurrentPage() {
		return curruntPage;
	}
	public void setCurrentPage(int curruntPage) {
		this.curruntPage = curruntPage;
	}

	public String getSearchCondition() {
		return searchCondition;
	}
	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}
	public String getSearchKeyword() {
		return searchKeyword;
	}
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	public int getPriceUpDown() {
		return priceUpDown;
	}

	public void setPriceUpDown(int priceUpDown) {
		this.priceUpDown = priceUpDown;
	}

	public int getRowNum() {
		return rowNum;
	}

	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}

	public int getBetween1() {
		return between1;
	}

	public void setBetween1(int between1) {
		this.between1 = between1;
	}

	public int getBetween2() {
		return between2;
	}

	public void setBetween2(int between2) {
		this.between2 = between2;
	}

	@Override
	public String toString() {
		return "Search [curruntPage=" + curruntPage + ", searchCondition=" + searchCondition + ", searchKeyword="
				+ searchKeyword + ", pageSize=" + pageSize + ", priceUpDown=" + priceUpDown + ", rowNum=" + rowNum
				+ ", between1=" + between1 + ", between2=" + between2 + "]";
	}



}