package com.yel.test.bookingapi.booking;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.yel.test.bookingapi.Exception.BookingNotFoundExeption;
import com.yel.test.bookingapi.Exception.RoomNotFoundException;
import com.yel.test.bookingapi.booking.models.Booking;
import com.yel.test.bookingapi.booking.service.BookingDateValidationService;
import com.yel.test.bookingapi.booking.service.BookingService;
import com.yel.test.bookingapi.booking.service.RoomService;

@RestController
@RequestMapping("/bookings")
public class BookingResource {
		
	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private RoomService roomService;
	
	@Autowired
	private BookingDateValidationService bookingDateValidationService;
	
	@PostMapping()
	public ResponseEntity<Object> createBooking(@Valid @RequestBody Booking booking) throws RoomNotFoundException{
		
		bookingDateValidationService.bookingValidateDate(booking.getCheckIn(), booking.getCheckOut());
		
		String reservationNumber = bookingService.save(booking);
		
		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{reservationNumber}")
			.buildAndExpand(reservationNumber).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping("/{reservationNumber}")
	public Booking retrieveBooking(@PathVariable String reservationNumber) {
		Booking booking = bookingService.findOne(reservationNumber);
		if(booking == null) {
			throw new BookingNotFoundExeption(reservationNumber);
		}
		
		return booking;
	}
	
	@PutMapping("/{reservationNumber}")
	public ResponseEntity<Object> updateBooking(@Valid @RequestBody Booking booking, @PathVariable String reservationNumber) throws RoomNotFoundException{
		
		bookingDateValidationService.bookingValidateDate(booking.getCheckIn(), booking.getCheckOut());
		
		Booking bookingToupdate = bookingService.findOne(reservationNumber);
		
		if(!bookingToupdate.getCheckIn().isEqual(booking.getCheckIn()) 
					|| !bookingToupdate.getCheckOut().isEqual(booking.getCheckOut())) {
			bookingDateValidationService.bookingValidateDate(booking.getCheckIn(), booking.getCheckOut());
			roomService.isRoomAvailable(bookingToupdate.getRoomId(), booking.getCheckIn(), booking.getCheckOut());
		}
		
		booking.setId(bookingToupdate.getId());
		bookingService.update(booking);
		
		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{reservationNumber}")
			.buildAndExpand(reservationNumber).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/{reservationNumber}")
	public void cancelBooking(@PathVariable String reservationNumber){
		bookingService.cancel(reservationNumber);
	}

}
