package org.example.service;

import org.example.model.ChestEntity;
import org.example.model.FreeRoomEntity;
import org.example.model.RoomEntity;
import org.example.model.TableEntity;
import org.example.objects.*;
import org.example.repository.ChestRepository;
import org.example.repository.FreeRoomRepository;
import org.example.repository.RoomRepository;
import org.example.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RoomService {
//    private List<Integer> free_ids = new ArrayList<>();
//    private List<Integer> list_of_id = new ArrayList<>();
//    private Map<Integer, Room> hashMap_of_rooms = new HashMap();
    @Autowired
    private FreeRoomRepository freeRoomRepository;

    @Autowired
    private RoomRepository  roomRepository;

    @Autowired
    private ChestRepository chestRepository;

    @Autowired
    private TableRepository tableRepository;

    private static final Random random = new Random();

    public int createEmptyRoomID(Room room){
        int result = getFreeId();

        RoomEntity roomEntity = new RoomEntity();
        roomEntity.setRoomId(result);
        roomEntity.setRoomName(room.getRoomName());
        roomRepository.save(roomEntity);

        List<Chest> chests = room.getChests();
        List<Table> tables = room.getTables();

        for (Chest c : chests) {
            ChestEntity e = new ChestEntity(c.getChestId(), c.getCoordinates().getTop(),
                    c.getCoordinates().getLeft(), true, null, null);
            e.setRoomEntity(roomEntity);
            chestRepository.save(e);
        }

        for (Table t : tables) {
            TableEntity e = new TableEntity(t.getCoordinates().getTop(), t.getCoordinates().getLeft());
            e.setRoomEntity(roomEntity);
            tableRepository.save(e);
        }

        return result;
    }

    public Room getRoomById(int roomId) {
        RoomEntity roomEntity = roomRepository.findByRoomId(roomId);

        List<ChestEntity> chestEntities = chestRepository.findByRoomEntity(roomEntity);
        List<TableEntity> tableEntities = tableRepository.findByRoomEntity(roomEntity);

        List<Chest> chests = fillChests(chestEntities);
        List<Table> tables = fillTables(tableEntities);

        Room room = new Room();
        room.setChests(chests);
        room.setTables(tables);
        room.setRoomId(roomId);
        room.setRoomName(roomEntity.getRoomName());

        return room;
    }

    public boolean takeChestByRoomId(int roomId, int chestId, User user) {
        RoomEntity roomEntity = roomRepository.findByRoomId(roomId);
//        ChestEntity chestEntity = chestRepository.findByChestIdAndRoomId(chestId, roomId);
        ChestEntity chestEntity = chestRepository.findByChestIdAndRoomEntity(chestId, roomEntity);
        if (!chestEntity.getFree()) return false;

        chestEntity.setUserDescription(user.getDescription());
        chestEntity.setUserName(user.getFullName());
        chestEntity.setFree(false);
        chestRepository.save(chestEntity);

        return true;
    }

    private int getFreeId() {
//        List<Integer> freeIds = freeRoomRepository.getAllFreeIds();
//        int freeId = freeIds.get(random.nextInt(freeIds.size()));
        List<FreeRoomEntity> freeRooms = freeRoomRepository.findAll();
        FreeRoomEntity randomRoom = freeRooms.get(random.nextInt(freeRooms.size()));
        int freeId = randomRoom.getFreeId();
        freeRoomRepository.delete(randomRoom);
        return freeId;
    }

    private List<Chest> fillChests(List<ChestEntity> chestEntities) {
        List<Chest> chests = new ArrayList<>();

        for (ChestEntity entity : chestEntities) {
            Chest chest = new Chest();
            chest.setChestId(entity.getChestId());
            Coordinates coordinates = new Coordinates();
            coordinates.setLeft(entity.getChestY());
            coordinates.setTop(entity.getChestX());
            chest.setCoordinates(coordinates);
            chest.setFree(entity.getFree());
            User user = new User();
            user.setDescription(entity.getUserDescription());
            user.setFullName(entity.getUserName());
            chest.setUser(user);
            chests.add(chest);
        }

        return chests;
    }

    private List<Table> fillTables(List<TableEntity> tableEntities) {
        List<Table> tables = new ArrayList<>();

        for (TableEntity entity : tableEntities) {
            Table table = new Table();
            Coordinates coordinates = new Coordinates();
            coordinates.setTop(entity.getTableX());
            coordinates.setLeft(entity.getTableY());
            table.setCoordinates(coordinates);
            tables.add(table);
        }

        return tables;
    }
}
