package org.example;

import org.example.objects.Room;
import org.example.objects.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataBase {
    private List<Integer> free_ids = new ArrayList<>();
    private List<Integer> list_of_id = new ArrayList<>();
    private Map<Integer, Room> hashMap_of_rooms = new HashMap();

    public DataBase(){
        initFree_Ids();
    }

    private int getFreeRndRoom(){
        return (int)(Math.random()*free_ids.size());
    }

    public int createEmptyRoomID(Room room){
        int result = free_ids.get(getFreeRndRoom());

        free_ids.remove(getFreeRndRoom());

        list_of_id.add(result);

        room.setRoomId(result);
        hashMap_of_rooms.put(result, room);

        return result;
    }

    public Room getRoomByID(int room_id){
        if (!list_of_id.contains(room_id)) {
            return null;
        }
        return hashMap_of_rooms.get(room_id);
    }

    public boolean takeChestByRoomID(int room_id, int chest_id, User user){
        return getRoomByID(room_id).takeChestByChestID(chest_id, user);
    }

    private void initFree_Ids(){
        for (int i = 0; i < 900_001; i++)
            free_ids.add(i + 100_000);
    }

    public boolean isCreated(int id){
        return list_of_id.contains(id);
    }

    public List<Integer> getList_of_id() {
        return list_of_id;
    }

    public Map<Integer, Room> getList_of_rooms() {
        return hashMap_of_rooms;
    }
}
