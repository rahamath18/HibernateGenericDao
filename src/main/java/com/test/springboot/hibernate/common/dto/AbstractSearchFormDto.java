package com.test.springboot.hibernate.common.dto;

import java.io.Serializable;

import com.test.springboot.hibernate.common.type.SortOrder;

public abstract class AbstractSearchFormDto implements Serializable {
		
	private static final long serialVersionUID = 1L;

	private int pageNum = 1;

    private int columnIndex;
    
    private SortOrder sortOrder = SortOrder.ASC;
    
	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
    
	public SortOrder getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(SortOrder sortOrder) {
		this.sortOrder = sortOrder;
	}

	public int getColumnIndex() {
		return columnIndex;
	}

	public void setColumnIndex(int columnIndex) {
		this.columnIndex = columnIndex;
	}
    
}
