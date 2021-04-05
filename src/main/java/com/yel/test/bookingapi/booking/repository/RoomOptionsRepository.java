package com.yel.test.bookingapi.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yel.test.bookingapi.booking.entities.RoomOptionsEntity;

@Repository
public interface RoomOptionsRepository extends JpaRepository<RoomOptionsEntity, Long>{

}
