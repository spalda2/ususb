package com.spalda.usu_sb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EmployeesAverageAge {
    
	public EmployeesAverageAge() {
		
	}
	
	public EmployeesAverageAge(int count, int avgage) {
		this.Average_Age = avgage;
		this.Count = count;
	}

	@Id
	@Column(name="Count")
    private int Count;

    @Column(name="`Average Age`")
    private int Average_Age;

	@Column(name="Count")
	public int getCount() {
		return Count;
	}

    @Column(name="`Average Age`")
	public int getAverage_Age() {
		return Average_Age;
	}

}
