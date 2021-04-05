package com.yel.test.bookingapi.booking.models;

import java.util.List;

public class Room {

	private long id;
	private String type;
	private int personMax;
	private String bedType;
	private List<RoomOptions> options;
	private int currentPrice;
	
	public Room(String type, int personMax, String bedType, List<RoomOptions> options, int currentPrice) {
		super();
		this.type = type;
		this.personMax = personMax;
		this.bedType = bedType;
		this.options = options;
		this.currentPrice = currentPrice;
	}
	
	public Room(long id, String type, int personMax, String bedType, int currentPrice) {
		super();
		this.id = id;
		this.type = type;
		this.personMax = personMax;
		this.bedType = bedType;
		this.currentPrice = currentPrice;
	}

	public long getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPersonMax() {
		return personMax;
	}

	public void setPersonMax(int personMax) {
		this.personMax = personMax;
	}

	public String getBedType() {
		return bedType;
	}

	public void setBedType(String bedType) {
		this.bedType = bedType;
	}

	public List<RoomOptions> getOptions() {
		return options;
	}

	public void setOptions(List<RoomOptions> options) {
		this.options = options;
	}

	public int getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(int currentPrice) {
		this.currentPrice = currentPrice;
	}

	@Override
	public String toString() {
		return "Room [type=" + type + ", personMax=" + personMax + ", bedType=" + bedType + ", options=" + options
				+ ", currentPrice=" + currentPrice + "]";
	}
	
	
	
	
}
