package com.cg.jpastart.entities;

import javax.persistence.Embeddable;

@Embeddable 
public class SeatInfo {
	int totalCount;
	int availableCount;
	int bookedCount;
	
	
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getAvailableCount() {
		return availableCount;
	}
	public void setAvailableCount(int availableCount) {
		this.availableCount = availableCount;
	}
	public int getBookedCount() {
		return bookedCount;
	}
	public void setBookedCount(int bookedCount) {
		this.bookedCount = bookedCount;
	}
	public SeatInfo() {
		super();
		
	}
	public SeatInfo(int totalCount, int availableCount, int bookedCount) {
		super();
		this.totalCount = totalCount;
		this.availableCount = availableCount;
		this.bookedCount = bookedCount;
	}
	@Override
	public String toString() {
		return "SeatInfo [totalCount=" + totalCount + ", availableCount="
				+ availableCount + ", bookedCount=" + bookedCount + "]";
	}


}
