package com.yel.test.bookingapi.booking.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yel.test.bookingapi.Exception.RoomNotFoundException;
import com.yel.test.bookingapi.booking.entities.BookingEntity;
import com.yel.test.bookingapi.booking.entities.RoomEntity;
import com.yel.test.bookingapi.booking.entities.RoomOptionsEntity;
import com.yel.test.bookingapi.booking.models.Room;
import com.yel.test.bookingapi.booking.models.RoomOptions;
import com.yel.test.bookingapi.booking.repository.RoomRepository;

@Service
public class RoomService {
	
	private static final Logger logger = LoggerFactory.getLogger(RoomService.class);

	@Autowired
	private RoomRepository roomRepository;
	
	public List<Room> findAllRooms() throws RoomNotFoundException{
		List<Room> rooms = new ArrayList<Room>();
		List<RoomEntity> roomsEntities = roomRepository.findAll();
		
		if(roomsEntities.isEmpty()) {
			throw new RoomNotFoundException("No room found");
		}
		for(RoomEntity re: roomsEntities) {
			rooms.add(new Room(re.getId(), re.getType(), re.getPersonMax(),
					re.getBedType(), re.getCurrentPrice()));
		}
		return rooms;
	}
	
	public Room findOneRoom(long id) throws RoomNotFoundException {
		Optional<RoomEntity> optre = roomRepository.findById(id);
		if(!optre.isPresent()) {
			throw new RoomNotFoundException("id-"+id);
		}
		RoomEntity re = optre.get();
		
		List<RoomOptionsEntity> roomOptionsEntities = re.getOptions();
		List<RoomOptions> roomOptions = new ArrayList<RoomOptions>();
		
		for(RoomOptionsEntity reop: roomOptionsEntities) {
			roomOptions.add(new RoomOptions(reop.getLabel(), reop.getNature()));
		}
		Room room = new Room(re.getType(),re.getPersonMax(), re.getBedType(), roomOptions, re.getCurrentPrice());
		
		return room;
	}
	
	public Room findOneRoomWithouOptions(long id) throws RoomNotFoundException {
		Optional<RoomEntity> optre = roomRepository.findById(id);
		if(!optre.isPresent()) {
			throw new RoomNotFoundException("id-"+id);
		}
		RoomEntity re = optre.get();
		
		Room room = new Room(re.getId(), re.getType(), re.getPersonMax(), re.getBedType(), re.getCurrentPrice());
		
		return room;
	}
	
	public Room isRoomAvailable(long id, LocalDate checkIn, LocalDate checkOut) throws RoomNotFoundException {
		Optional<RoomEntity> optre = roomRepository.findById(id);
		
		if(!optre.isPresent()) {
			throw new RoomNotFoundException("Not found room ith id: "+id);
		}
		
		RoomEntity re = optre.get();
		List<BookingEntity> bookingsEntity = re.getBookings();
		
		List<BookingEntity> filteringBooking = bookingsEntity.stream()
				.filter(be -> (be.getCheckIn().compareTo(checkIn) >= 0 && be.getCheckIn().compareTo(checkOut) < 0)
						|| (be.getCheckOut().compareTo(checkIn) > 0 && be.getCheckOut().compareTo(checkOut) <= 0))
				.collect(Collectors.toList());
		
		if(!filteringBooking.isEmpty()) {
			throw new RoomNotFoundException("No available room for the date between " + checkIn + " and " + checkOut);
		}
		
		return new Room(re.getId(), re.getType(), re.getPersonMax(), re.getBedType(), re.getCurrentPrice());
	}
}
