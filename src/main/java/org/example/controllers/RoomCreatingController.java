package org.example.controllers;

import org.example.Server;
import org.example.objects.Room;
import org.example.repository.RoomRepository;
import org.example.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
public class RoomCreatingController {

    @Autowired
    private RoomService roomService;

    //TODO: ДОБАВИТЬ ПРОВЕРКУ НА СОЗДАНИЕ КОМНАТЫ В createRoom

    @RequestMapping(value = "/newroom", method = RequestMethod.POST)
    @ResponseBody
    public int createRoom(@Validated @RequestBody Room created_room){
        return roomService.createEmptyRoomID(created_room);
//        return Server.db.createEmptyRoomID(created_room);
    }
}
