package com.yel.test.bookingapi.booking.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Room")
public class RoomEntity {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(name = "room_type")
	private String type;
	
	@Column(name = "person_max")
	private int personMax;
	
	@Column(name = "bed_type")
	private String bedType;
	
	@OneToMany(mappedBy = "room")
	private List<RoomOptionsEntity> options;
	
	@OneToMany(mappedBy = "room")
	private List<BookingEntity> bookings;

	@Column(name = "current_price")
	private int currentPrice;

	public RoomEntity() {
		
	}
	public RoomEntity(String type, int personMax, String bedType,
			int currentPrice) {
		super();
		this.type = type;
		this.personMax = personMax;
		this.bedType = bedType;
		this.currentPrice = currentPrice;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setPersonMax(int personMax) {
		this.personMax = personMax;
	}

	public void setBedType(String bedType) {
		this.bedType = bedType;
	}

	public void setOptions(List<RoomOptionsEntity> options) {
		this.options = options;
	}

	public void setBookings(List<BookingEntity> bookings) {
		this.bookings = bookings;
	}

	public void setCurrentPrice(int currentPrice) {
		this.currentPrice = currentPrice;
	}

	public String getType() {
		return type;
	}

	public int getPersonMax() {
		return personMax;
	}

	public String getBedType() {
		return bedType;
	}

	public List<RoomOptionsEntity> getOptions() {
		return options;
	}
	
	public List<BookingEntity> getBookings() {
		return bookings;
	}

	public int getCurrentPrice() {
		return currentPrice;
	}

	@Override
	public String toString() {
		return "RoomEntity [id=" + id + ", type=" + type + ", personMax=" + personMax + ", bedType=" + bedType
				+ ", currentPrice=" + currentPrice + "]";
	}
	
	
	
	
}
