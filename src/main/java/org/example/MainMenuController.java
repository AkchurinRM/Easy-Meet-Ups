package org.example;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainMenuController {
    @RequestMapping(value = "/room/{roomId}", method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Room getRoom(@PathVariable int roomId){
        return Server.db.getRoomByID(roomId);
    }
}
