package com.yel.test.bookingapi.booking.mapper;

import org.springframework.stereotype.Component;

import com.yel.test.bookingapi.booking.entities.BookingEntity;
import com.yel.test.bookingapi.booking.entities.RoomEntity;
import com.yel.test.bookingapi.booking.models.Booking;
import com.yel.test.bookingapi.booking.models.Room;

@Component
public class BookingMapper {

	public Booking bookingEnitityToBooking(BookingEntity bookingEntity) {
		
		Booking booking = new Booking();
		booking.setId(bookingEntity.getId());
		booking.setFirstName(bookingEntity.getFirstName());
		booking.setLastName(bookingEntity.getLastName());
		booking.setPhoneNumber(bookingEntity.getPhoneNumber());
		booking.setCheckIn(bookingEntity.getCheckIn());
		booking.setCheckOut(bookingEntity.getCheckOut());
		booking.setEmail(bookingEntity.getEmail());
		booking.setReservationNumber(bookingEntity.getReservationNumber());
		booking.setRoomId(bookingEntity.getRoom().getId());
		
		return booking;
	}

	public BookingEntity bookingToBookingEnitity(Booking booking) {
		
		String reservationNumber = booking.getFirstName().toLowerCase().replaceAll(" ", "")
				+ booking.getLastName().toLowerCase().replaceAll(" ", "");
		
		BookingEntity bookingEntity = new BookingEntity();
		bookingEntity.setFirstName(booking.getFirstName());
		bookingEntity.setLastName(booking.getLastName());
		bookingEntity.setPhoneNumber(booking.getPhoneNumber());
		bookingEntity.setCheckIn(booking.getCheckIn());
		bookingEntity.setCheckOut(booking.getCheckOut());
		bookingEntity.setEmail(booking.getEmail());
		bookingEntity.setReservationNumber(reservationNumber);

		return bookingEntity;
	}
	
	public RoomEntity roomToRoomEntiry(Room room) {
		RoomEntity re = new RoomEntity();
		re.setId(room.getId());
		re.setBedType(room.getBedType());
		re.setCurrentPrice(room.getCurrentPrice());
		re.setPersonMax(room.getPersonMax());
		
		return re;
	}
}
