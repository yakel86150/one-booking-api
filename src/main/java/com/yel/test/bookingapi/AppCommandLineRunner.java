package com.yel.test.bookingapi;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.yel.test.bookingapi.booking.entities.BookingEntity;
import com.yel.test.bookingapi.booking.entities.RoomEntity;
import com.yel.test.bookingapi.booking.entities.RoomOptionsEntity;
import com.yel.test.bookingapi.booking.repository.BookingRepository;
import com.yel.test.bookingapi.booking.repository.RoomOptionsRepository;
import com.yel.test.bookingapi.booking.repository.RoomRepository;

@Component
public class AppCommandLineRunner implements CommandLineRunner{
	
	private static final Logger log = LoggerFactory.getLogger(AppCommandLineRunner.class);
	@Autowired
	private RoomRepository roomRepository;
	
	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private RoomOptionsRepository optionsRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		RoomEntity re = new RoomEntity("Deluxe Room", 2, "King Size", 100);
		roomRepository.save(re);
		RoomEntity reSaved = roomRepository.findById(1L).get();
		
		RoomOptionsEntity roomOtions1 = new RoomOptionsEntity("Wi-fi", "free", reSaved);
		RoomOptionsEntity roomOtions2 = new RoomOptionsEntity("Breakfast", "free", reSaved);
		optionsRepository.save(roomOtions1);
		optionsRepository.save(roomOtions2);
		
		BookingEntity bookingEntity = new BookingEntity("John", "Yummel", "aze@gmm.fr","0911092209", "klklklklklklk",
									LocalDate.parse("2021-04-09"), LocalDate.parse("2021-04-11"), reSaved);
		
		BookingEntity bookingEntity2 = new BookingEntity("Mariel", "Yohanna", "aze@gmm.fr","0911092209", "appolaaert",
				LocalDate.parse("2021-04-17"), LocalDate.parse("2021-04-18"), reSaved);
		
		BookingEntity bookingEntity3 = new BookingEntity("Francis", "Lionel", "aze@gmm.fr","0911092209", "lionelfrancis",
				LocalDate.parse("2021-04-20"), LocalDate.parse("2021-04-25"), reSaved);
		
		bookingRepository.save(bookingEntity);
		bookingRepository.save(bookingEntity2);
		bookingRepository.save(bookingEntity3);
		
	}

}
