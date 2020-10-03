package org.example.repository;

import org.example.model.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<RoomEntity, Integer> {
    RoomEntity findByRoomId(Integer roomId);
}
