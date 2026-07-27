package com.vsm.userservice.entity;

public class Hotel {
	
	private Long id;
	private String name;
	private String loction;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLoction() {
		return loction;
	}
	public void setLoction(String loction) {
		this.loction = loction;
	}
	
	public Hotel(Long id, String name, String loction) {
		super();
		this.id = id;
		this.name = name;
		this.loction = loction;
	}
	
	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
