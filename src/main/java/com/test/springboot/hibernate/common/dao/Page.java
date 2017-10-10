package com.test.springboot.hibernate.common.dao;

import java.util.List;

public class Page<T> {
	private int pageNum;
	private int pageSize;
	private int totalPages;
	private int totalRecords;
	private int startIndex;
	private int startRecordNumber;
	private boolean firstPage;
	private boolean lastPage;
	private List<T> records;
	
	
	/**
	 * if this page is the first page
	 * @return
	 */
	public boolean isFirstPage() {
		return firstPage;
	}
	
	public void setFirstPage(boolean firstPage) {
		this.firstPage = firstPage;
	}
	
	/**
	 * Record number of the first entry in page. This is a convinience method that should always have a value of startIndex + 1.
	 * @return
	 */
	public int getStartRecordNumber() {
		return startRecordNumber;
	}
	
	public void setStartRecordNumber(int firstRecordNumber) {
		this.startRecordNumber = firstRecordNumber;
	}
	
	/**
	 * If this page is the last page
	 * @return
	 */
	public boolean isLastPage() {
		return lastPage;
	}
	
	public void setLastPage(boolean lastPage) {
		this.lastPage = lastPage;
	}
	
	/**
	 * get the page number of the page
	 * @return
	 */
	public int getPageNum() {
		return pageNum;
	}
	
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	
	/**
	 * get the page size
	 * @return
	 */
	public int getPageSize() {
		return pageSize;
	}
	
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	/**
	 * returns the list of records in the page
	 * @return
	 */
	public List<T> getRecords() {
		return records;
	}
	
	public void setRecords(List<T> records) {
		this.records = records;
	}
	
	/**
	 * Index position of the first record in page in reference to the full result set.
	 * @return
	 */
	public int getStartIndex() {
		return startIndex;
	}
	
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	
	/**
	 * Get total number of records
	 * @return
	 */
	public int getTotalRecords() {
		return totalRecords;
	}
	
	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	/**
	 * returns the number of pages in the full result set according to the page size
	 * @return
	 */
	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

}
