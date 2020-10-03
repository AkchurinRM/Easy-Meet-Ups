package org.example.controllers;

import org.example.Server;
import org.example.objects.User;
import org.example.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class InRoomController {

    @Autowired
    private RoomService roomService;

    @RequestMapping(value = "/room/{roomId}/{chestId}", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public boolean takePlace(@PathVariable int roomId, @PathVariable int chestId, @RequestBody User user){
        return roomService.takeChestByRoomId(roomId, chestId, user);
//        return Server.db.takeChestByRoomID(roomId, chestId, user);
    }
}
