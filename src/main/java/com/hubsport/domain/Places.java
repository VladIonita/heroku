package com.hubsport.domain;

public class Places {

	private int id;
	private String name;
	private String address;
	private Towns towns_id;



	public Places() {
	}
	
	public Places(int id, String name) {
		this.id = id;
		this.name = name;
	}


	public Places(String name, String address) {
		this.name = name;
		this.address = address;
	}

	
	public Towns getTowns() {
		return towns_id;
	}

	public void setTowns(Towns towns) {
		this.towns_id = towns;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Places [id=" + id + ", name=" + name + ", address=" + address + ", towns=" + towns_id + "]";
	}


}
