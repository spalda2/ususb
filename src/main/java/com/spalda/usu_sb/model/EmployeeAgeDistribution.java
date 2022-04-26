package com.spalda.usu_sb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EmployeeAgeDistribution {

	public EmployeeAgeDistribution() {
		
	}
	
	public EmployeeAgeDistribution(int count, String avgage) {
		this.Average_Age = avgage;
		this.Count_of_Employees = count;
	}

	@Id
	@Column(name="Count of Employees")
    private int Count_of_Employees;

    @Column(name="`Average Age`")
    private String Average_Age;

	@Column(name="Count of Employees")
	public int getCount_of_Employees() {
		return Count_of_Employees;
	}

    @Column(name="`Average Age`")
	public String getAverage_Age() {
		return Average_Age;
	}


}
