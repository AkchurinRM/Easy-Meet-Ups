package org.example.repository;

import org.example.model.RoomEntity;
import org.example.model.TableEntity;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TableRepository extends JpaRepository<TableEntity, Integer> {
    List<TableEntity> findByRoomEntity(RoomEntity roomEntity);
}