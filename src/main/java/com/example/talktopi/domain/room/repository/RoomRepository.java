package com.example.talktopi.domain.room.repository;

import com.example.talktopi.domain.room.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Integer> {
}
