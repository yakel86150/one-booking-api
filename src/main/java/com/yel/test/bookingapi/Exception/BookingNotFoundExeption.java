package com.yel.test.bookingapi.Exception;

public class BookingNotFoundExeption extends RuntimeException {

	public BookingNotFoundExeption(String message) {
		super(message);
	}
}
