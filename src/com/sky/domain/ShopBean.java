package com.sky.domain;

import java.util.List;

public class ShopBean {

	private List<Shop> list;// 每页的数据内容
	private int pageNo;// 当前页
	private int totalPage;// 总页数
	
	
	
	private int startPos;//页面显示页数的开始位置
	private int endPos;//页面显示页数的结束位置

	public List<Shop> getList() {
		return list;
	}

	public void setList(List<Shop> list) {
		this.list = list;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getStartPos() {
		return startPos;
	}

	public void setStartPos(int startPos) {
		this.startPos = startPos;
	}

	public int getEndPos() {
		return endPos;
	}

	public void setEndPos(int endPos) {
		this.endPos = endPos;
	}

	@Override
	public String toString() {
		return "ShopBean [list=" + list + ", pageNo=" + pageNo + ", totalPage=" + totalPage + ", startPos=" + startPos
				+ ", endPos=" + endPos + "]";
	}

	
}
