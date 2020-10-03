package org.example.repository;

import org.example.model.ChestEntity;
import org.example.model.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChestRepository extends JpaRepository<ChestEntity, Integer> {
    ChestEntity findByChestIdAndRoomEntity(Integer chestId, RoomEntity roomEntity);

//    @Query("select c from ChestEntity where c.chestId =:chestId and c.roomEntity.roomId =:roomId")
//    ChestEntity findByChestIdAndRoomId(Integer chestId, Integer roomId);

//    ChestEntity findByChestIdAndRoomEntity(Integer chestId, RoomEntity roomEntity);

    List<ChestEntity> findByRoomEntity(RoomEntity roomEntity);
}
