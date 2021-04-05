package com.yel.test.bookingapi.booking.models;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Booking {

	@JsonIgnore
	private long id;
	
	@NotNull
	@Size(min = 3, message = "Should at least have 3 characteres")
	private String firstName;
	
	@NotNull
	@Size(min = 3, message = "Should at least have 3 characteres")
	private String lastName;
	
	@Email
	@NotNull
	private String email;
	
	@NotNull
	@Size(min = 11, message = "Should at least have 11 characteres")
	private String phoneNumber;
	private String reservationNumber;
	
	@NotNull
	private long roomId;
	
	@NotNull
	private LocalDate checkIn;
	
	@NotNull
	private LocalDate checkOut;
	
	public Booking() {
		
	}
	
	public Booking(long id, String firstName, String lastName, String email, String phoneNumber,
			long roomId, LocalDate checkIn, LocalDate checkOut) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.roomId = roomId;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public long getId() {
		return id;
	}

	public long getRoomId() {
		return roomId;
	}

	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getReservationNumber() {
		return reservationNumber;
	}

	public void setReservationNumber(String reservationNumber) {
		this.reservationNumber = reservationNumber;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(LocalDate checkIn) {
		this.checkIn = checkIn;
	}

	public LocalDate getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(LocalDate checkOut) {
		this.checkOut = checkOut;
	}

	@Override
	public String toString() {
		return "Booking [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phoneNumber="
				+ phoneNumber + ", checkIn=" + checkIn + ", checkOut=" + checkOut;
	}

	
		
	
	
}
