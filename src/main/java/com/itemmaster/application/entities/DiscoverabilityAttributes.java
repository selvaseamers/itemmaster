package com.itemmaster.application.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DiscoverabilityAttributes {

	@Id
	private String id;
	private String flavor;
	private Integer count;
	private Integer size;
	private boolean isReadyToEat;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFlavor() {
		return flavor;
	}

	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public boolean isReadyToEat() {
		return isReadyToEat;
	}

	public void setReadyToEat(boolean isReadyToEat) {
		this.isReadyToEat = isReadyToEat;
	}

}
