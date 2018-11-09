package com.capgemini.business;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Emp")
public class Employee {
	@Id
	@Column(name="Emp_id")
	private int empid;
	
	@Column(name="Emp_name")
	private String empname;
	
	@Column(name="Emp_basic")
	private double basicSalary;

	@Column(name="Emp_gender")
	private char empGender;
	
	@Column(name="Emp_grade")
	private char empgrade;

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public double getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}

	public char getEmpGender() {
		return empGender;
	}

	public void setEmpGender(char empGender) {
		this.empGender = empGender;
	}

	public char getEmpgrade() {
		return empgrade;
	}

	public void setEmpgrade(char empgrade) {
		this.empgrade = empgrade;
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", empname=" + empname
				+ ", basicSalary=" + basicSalary + ", empGender=" + empGender
				+ ", empgrade=" + empgrade + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + empid;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (empid != other.empid)
			return false;
		return true;
	}

}
