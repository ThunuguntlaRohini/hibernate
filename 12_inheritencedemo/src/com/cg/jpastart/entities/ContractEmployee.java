package com.cg.jpastart.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CE")
public class ContractEmployee extends Employee {
	private int duration;
	boolean extendable;
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public boolean isExtendable() {
		return extendable;
	}
	public void setExtendable(boolean extendable) {
		this.extendable = extendable;
	}
	@Override
	public String toString() {
		return "ContractEmployee [duration=" + duration + ", extendable="
				+ extendable + ", getEmployeeId()=" + getEmployeeId()
				+ ", getName()=" + getName() + ", getSalary()=" + getSalary()
				+ "]";
	}

	

}
