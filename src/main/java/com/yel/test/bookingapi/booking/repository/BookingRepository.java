package com.yel.test.bookingapi.booking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yel.test.bookingapi.booking.entities.BookingEntity;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntity, Long>{

	public Optional<BookingEntity> findByReservationNumber(String reservationNumber);
	
	public void deleteByReservationNumber(String reservatioNumber);
}
