package org.example.objects;

import org.example.objects.Chest;
import org.example.objects.Table;
import org.example.objects.User;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private int roomId;
    private String roomName;
    private List<Chest> chests = new ArrayList<>();
    private List<Table> tables = new ArrayList<>();

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public List<Chest> getChests() {
        return chests;
    }

    public boolean takeChestByChestID(int chest_id, User user){
        for (int i = 0; i < chests.size();i++){
            if (chest_id == chests.get(i).getChestId()){
                if (!chests.get(i).isFree()) return false;
                chests.get(i).setUser(user);
                chests.get(i).setFree(false);
            }
        }
        return true;
    }

    public boolean checkChestByChestID(int chest_id){
        for (int i = 0; i < chests.size();i++){
            if (chest_id == chests.get(i).getChestId()){
                return chests.get(i).isFree();
            }
        }
        return false;
    }

    public void setChests(List<Chest> chests) {
        this.chests = chests;
    }

    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }
}
