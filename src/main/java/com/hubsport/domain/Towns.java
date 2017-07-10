package com.hubsport.domain;

public class Towns {

	private int id;
	private String name;
	private Districts districts;

	public Towns() {
	}
	
	public Towns(int id) {
		this.id = id;
	}



	public Towns(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Districts getDistricts() {
		return districts;
	}

	public void setDistricts(Districts districts) {
		this.districts = districts;
	}

	@Override
	public String toString() {
		return "Towns [id=" + id + ", name=" + name + ", districts=" + districts + "]";
	}

}
