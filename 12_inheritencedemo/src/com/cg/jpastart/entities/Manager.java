package com.cg.jpastart.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("MGR")	//value for manager rows in Discriminator column
public class Manager extends Employee {

	@Override
	public String toString() {
		return "Manager [departmentName=" + departmentName
				+ ", getEmployeeId()=" + getEmployeeId() + ", getName()="
				+ getName() + ", getSalary()=" + getSalary() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	private static final long serialVersionUID = 1L;
	
	private String departmentName;

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	

}
