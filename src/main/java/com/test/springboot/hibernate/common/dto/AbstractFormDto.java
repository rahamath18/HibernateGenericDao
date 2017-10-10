package com.test.springboot.hibernate.common.dto;

import java.io.Serializable;
import java.util.Date;

public abstract class AbstractFormDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	protected Date createdDate;
    protected long createdBy;
    protected Date updatedDate;
    protected long updatedBy;
    protected boolean logicallyDeleted = false;
    protected boolean isReadOnly = false;
    
    
	public boolean isReadOnly() {
		return isReadOnly;
	}
	public void setReadOnly(boolean isReadOnly) {
		this.isReadOnly = isReadOnly;
	}
	public long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public boolean isLogicallyDeleted() {
		return logicallyDeleted;
	}
	public void setLogicallyDeleted(boolean logicallyDeleted) {
		this.logicallyDeleted = logicallyDeleted;
	}
	public long getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(long updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

    
}
