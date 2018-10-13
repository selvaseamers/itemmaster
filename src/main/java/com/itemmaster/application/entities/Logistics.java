package com.itemmaster.application.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Logistics {

	@Id
	private String id;
	private Float msrp;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Float getMsrp() {
		return msrp;
	}

	public void setMsrp(Float msrp) {
		this.msrp = msrp;
	}

}
