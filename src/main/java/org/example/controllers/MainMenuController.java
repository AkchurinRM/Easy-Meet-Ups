package org.example.controllers;

import org.example.Server;
import org.example.objects.Room;
import org.example.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainMenuController {

    @Autowired
    private RoomService roomService;

    @RequestMapping(value = "/room/{roomId}", method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Room getRoom(@PathVariable int roomId){
        return roomService.getRoomById(roomId);
    }
}
