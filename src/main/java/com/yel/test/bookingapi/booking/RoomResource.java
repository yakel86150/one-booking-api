package com.yel.test.bookingapi.booking;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yel.test.bookingapi.Exception.RoomNotFoundException;
import com.yel.test.bookingapi.booking.models.Room;
import com.yel.test.bookingapi.booking.service.BookingDateValidationService;
import com.yel.test.bookingapi.booking.service.RoomService;

@RestController
@RequestMapping(path = "/rooms")
public class RoomResource {
	
	@Autowired
	private RoomService roomService;
	
	@Autowired
	private BookingDateValidationService bookingDateValidationService;
	
	@GetMapping
	public List<Room> retrievAll() throws RoomNotFoundException{
		return roomService.findAllRooms(); 
	}
	
	@GetMapping("/{id}")
	public Room retrievOneRoom(@PathVariable long id) throws RoomNotFoundException {
		return roomService.findOneRoom(id);
	}
	
	@GetMapping("/{id}/check")
	public Room checkisRoomAvalaible(@PathVariable long id,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate checkIn,
			@RequestParam  @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate checkOut) throws RoomNotFoundException {

		bookingDateValidationService.bookingValidateDate(checkIn, checkOut);
		
		Room room = roomService.isRoomAvailable(id, checkIn, checkOut);
		return room;
	}
}
