package com.hubsport.domain;

public class Districts {

	private int id;
	private String name;

	public Districts() {
	}

	public Districts(String name) {
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

	@Override
	public String toString() {
		return "Districts [id=" + id + ", name=" + name + "]";
	}

}
