package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Server {
    public static DataBase db = new DataBase();
    //Method to test correct json format
    public static int TestDB(){
        Room room = new Room();
        room.setRoomId(100_001);
        room.setRoomName("Test Room");
        List<Chest> chests = new ArrayList<>();
        List<Table> tables = new ArrayList<>();

        Chest chest1 = new Chest();
        Coordinates coords = new Coordinates();
        coords.setTop(123);
        coords.setLeft(90);
        chest1.setCoordinates(coords);
        chest1.setChestId(0);
        chest1.setFree(false);
        User user1 = new User();
        user1.setDescription("Desc 1323132");
        user1.setFullName("Akchur Ren");
        chest1.setUser(user1);

        Chest chest2 = new Chest();
        Coordinates coords2 = new Coordinates();
        coords2.setTop(123);
        coords2.setLeft(90);
        chest2.setCoordinates(coords2);
        chest2.setChestId(1);
        chest2.setFree(false);
        User user2 = new User();
        user2.setDescription("Descripy 13rwee23132");
        user2.setFullName("ZaMax");
        chest2.setUser(user2);

        chests.add(chest1);
        chests.add(chest2);

        room.setChests(chests);

        Table table1 = new Table();
        Coordinates coords3 = new Coordinates();
        coords3.setTop(123);
        coords3.setLeft(90);
        table1.setCoordinates(coords3);

        Table table2 = new Table();
        Coordinates coords4 = new Coordinates();
        coords4.setTop(123);
        coords4.setLeft(90);
        table2.setCoordinates(coords4);

        tables.add(table1);
        tables.add(table2);

        room.setTables(tables);

        return db.createEmptyRoomID(room);
    }

    public static void main(String[] args){
        System.out.println(TestDB());
        SpringApplication.run(Server.class);
    }
}
