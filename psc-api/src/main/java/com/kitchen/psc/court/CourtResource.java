package com.kitchen.psc.court;

import com.kitchen.psc.resource.ResourceWithEmbeddeds;

/**
 * @author Kevin Chen
 */
public class CourtResource extends ResourceWithEmbeddeds {

	private int number;

	private String name;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
