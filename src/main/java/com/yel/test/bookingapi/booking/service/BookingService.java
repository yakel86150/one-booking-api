package com.yel.test.bookingapi.booking.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yel.test.bookingapi.Exception.BookingNotFoundExeption;
import com.yel.test.bookingapi.Exception.RoomNotFoundException;
import com.yel.test.bookingapi.booking.entities.BookingEntity;
import com.yel.test.bookingapi.booking.entities.RoomEntity;
import com.yel.test.bookingapi.booking.mapper.BookingMapper;
import com.yel.test.bookingapi.booking.models.Booking;
import com.yel.test.bookingapi.booking.models.Room;
import com.yel.test.bookingapi.booking.repository.BookingRepository;

@Service
public class BookingService {

	@Autowired
	private BookingRepository bookingRepository;

	@Autowired
	private BookingMapper bookingMapper;

	@Autowired
	private RoomService roomService;

	public Booking findOne(String reservationNumber) {
		Optional<BookingEntity> bookingEntity = bookingRepository.findByReservationNumber(reservationNumber);

		if (!bookingEntity.isPresent()) {
			throw new BookingNotFoundExeption("reservationNumber - " + reservationNumber);
		}

		Booking booking = bookingMapper.bookingEnitityToBooking(bookingEntity.get());

		return booking;
	}

	public String save(Booking booking) throws RoomNotFoundException {

		BookingEntity bookingEntity = bookingMapper.bookingToBookingEnitity(booking);

		Room room = roomService.isRoomAvailable(booking.getRoomId(), booking.getCheckIn(), booking.getCheckOut());
		RoomEntity roomEntity = bookingMapper.roomToRoomEntiry(room);

		bookingEntity.setRoom(roomEntity);
		bookingRepository.save(bookingEntity);

		return bookingEntity.getReservationNumber();
	}

	public String update(Booking booking) throws RoomNotFoundException {
		BookingEntity bookingEntity = bookingMapper.bookingToBookingEnitity(booking);
		
		Room ro = roomService.findOneRoomWithouOptions(booking.getRoomId());
		RoomEntity roomEntityToUpdate = bookingMapper.roomToRoomEntiry(ro);
		
		bookingEntity.setRoom(roomEntityToUpdate);
		bookingEntity.setId(booking.getId());
		bookingEntity.setReservationNumber(booking.getReservationNumber());
		
		bookingRepository.save(bookingEntity);
		
		return bookingEntity.getReservationNumber();

	}
	
	@Transactional
	public void cancel(String reservationNumber) {		
		bookingRepository.deleteByReservationNumber(reservationNumber);

	}
}
