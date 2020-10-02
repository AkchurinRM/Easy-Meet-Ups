package org.example.controllers;

import org.example.Server;
import org.example.objects.User;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class InRoomController {
    @RequestMapping(value = "/getuser", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public User takePlace(){
        User user = new User();
        user.setFullName("231");
        user.setDescription("desc");
        return user;
    }

    @RequestMapping(value = "/room/{roomId}/{chestId}", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public boolean takePlace(@PathVariable int roomId, @PathVariable int chestId, @RequestBody User user){
        System.out.println(user.getFullName());
        return Server.db.takeChestByRoomID(roomId, chestId, user);
    }
}
