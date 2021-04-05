package com.yel.test.bookingapi.booking.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Service;

import com.yel.test.bookingapi.Exception.DateMisMatchException;

@Service
public class BookingDateValidationService {

	public void bookingValidateDate(LocalDate checkIn, LocalDate checkOut) {

		LocalDate today = LocalDate.now();

		if (checkIn.compareTo(today) <= 0) {
			throw new DateMisMatchException(
					"The room can not be available the same day as the reservation but one day after");
		}

		if (checkOut.compareTo(checkIn) <= 0) {
			throw new DateMisMatchException("The checkout date can not be before or the same day as the checkin date");
		}

		if (ChronoUnit.DAYS.between(checkIn, checkOut) > 3) {
			throw new DateMisMatchException("The staty can not be longer than 3 days");
		}

		if (ChronoUnit.DAYS.between(today, checkIn) > 30) {
			throw new DateMisMatchException("You can not book the room 30 days in advance");
		}
	}

}
