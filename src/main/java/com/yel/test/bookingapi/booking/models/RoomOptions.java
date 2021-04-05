package com.yel.test.bookingapi.booking.models;

public class RoomOptions {

	private String label;
	private String nature;
	
	public RoomOptions(String label, String nature) {
		super();
		this.label = label;
		this.nature = nature;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getNature() {
		return nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	@Override
	public String toString() {
		return "RoomOptions [label=" + label + ", nature=" + nature + "]";
	}
	
	
	
}
