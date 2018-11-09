package com.cg.jpastart.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="mgr_store2")
public class Manager extends Employee {


	private static final long serialVersionUID = 1L;
	
	private String departmentName;

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@Override
	public String toString() {
		return "Manager [departmentName=" + departmentName
				+ ", getEmployeeId()=" + getEmployeeId() + ", getName()="
				+ getName() + ", getSalary()=" + getSalary() + "]";
	}
	
	

}
