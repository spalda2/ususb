package com.spalda.usu_sb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="pk")
    private Long id;
    
    @Column(name="Name")
    private String Name;
    
    @Column(name="Age")
    private int Age;
    
    @Column(name="Position")
    private String Position;

    public Employee() {}
    
    public Employee(String name, int age, String position) {
    	this.Name = name;
    	this.Age = age;
    	this.Position = position;
    }

    public Long getId() {
		return id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		this.Name = name;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		this.Age = age;
	}

	public String getPosition() {
		return Position;
	}

	public void setPosition(String position) {
		this.Position = position;
	}
}
