package com.lgcns.mission.pension;

public class Customer {
	
	private String name;
	private String phone;
	
	public Customer(String name, String phone) {
		super();
		this.name = name;
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Tamu saat ini - [" + name + "] IU [" + phone + "] 010-8989-5656";
	}
	
	
}
