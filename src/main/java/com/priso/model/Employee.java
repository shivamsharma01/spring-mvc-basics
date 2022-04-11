package com.priso.model;

public class Employee {
	private int age;
	private String name;
	private String company;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Employee [age=" + age + ", name=" + name + ", company=" + company + "]";
	}

}
