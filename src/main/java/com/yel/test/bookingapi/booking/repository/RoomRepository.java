package com.yel.test.bookingapi.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yel.test.bookingapi.booking.entities.RoomEntity;

@Repository
public interface RoomRepository extends JpaRepository<RoomEntity, Long>{

}
