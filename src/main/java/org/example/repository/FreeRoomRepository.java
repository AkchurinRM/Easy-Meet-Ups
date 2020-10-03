package org.example.repository;

import org.example.model.FreeRoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FreeRoomRepository extends JpaRepository<FreeRoomEntity, Integer> {
    @Query("select f.freeId from FreeRoomEntity f")
    List<Integer> getAllFreeIds();
}
