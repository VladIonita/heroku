package com.hubsport.domain;

public class Broadcasters {
	private int id;
	private String name;

	public Broadcasters() {
	}

	public Broadcasters(String name) {
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
		return "Broadcasters [id=" + id + ", name=" + name + "]";
	}

}
