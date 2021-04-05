package com.yel.test.bookingapi.booking.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Booking")
public class BookingEntity {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "reservation_number")
	private String reservationNumber;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private RoomEntity room;
	
	@Column(name = "check_in_date")
	private LocalDate checkIn;
	
	@Column(name = "check_out_date")
	private LocalDate checkOut;
	
	public BookingEntity() {
		
	}

	public BookingEntity(String firstName, String lastName, String email, String phoneNumber, String reservationNumber,
			LocalDate checkIn, LocalDate checkOut, RoomEntity room) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.reservationNumber = reservationNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.room = room;
	}
	

	public void setId(long id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setReservationNumber(String reservationNumber) {
		this.reservationNumber = reservationNumber;
	}

	public void setRoom(RoomEntity room) {
		this.room = room;
	}

	public void setCheckIn(LocalDate checkIn) {
		this.checkIn = checkIn;
	}

	public void setCheckOut(LocalDate checkOut) {
		this.checkOut = checkOut;
	}

	public long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getReservationNumber() {
		return reservationNumber;
	}
	
	
	public RoomEntity getRoom() {
		return room;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}

	public LocalDate getCheckOut() {
		return checkOut;
	}

	@Override
	public String toString() {
		return "BookingEntity [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", reservationNumber=" + reservationNumber + ", checkIn=" + checkIn
				+ ", checkOut=" + checkOut + "]";
	}
	
	
	
	
	
	
}
