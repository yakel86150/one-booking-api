package com.yel.test.bookingapi.booking.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Room_Options")
public class RoomOptionsEntity {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String label;
	
	private String nature;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private RoomEntity room;
	
	protected RoomOptionsEntity() {
		
	}

	public RoomOptionsEntity(String label, String nature, RoomEntity room) {
		super();
		this.label = label;
		this.nature = nature;
		this.room = room;
	}
	

	public void setId(long id) {
		this.id = id;
	}


	public void setLabel(String label) {
		this.label = label;
	}


	public void setNature(String nature) {
		this.nature = nature;
	}


	public void setRoom(RoomEntity room) {
		this.room = room;
	}


	public long getId() {
		return id;
	}

	public String getLabel() {
		return label;
	}

	public String getNature() {
		return nature;
	}

	public RoomEntity getRoom() {
		return room;
	}
	
	
	

}
