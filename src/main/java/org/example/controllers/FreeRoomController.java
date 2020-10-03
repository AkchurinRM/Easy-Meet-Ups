package org.example.controllers;

import org.example.model.FreeRoomEntity;
import org.example.repository.FreeRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FreeRoomController {

    @Autowired
    private FreeRoomRepository freeRoomRepository;

    @RequestMapping(value = "/5556363/3/4/5/6", method = RequestMethod.PUT,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public String fillFreeRooms() {
        for (int i = 100_100; i < 100_200; i++) {
            FreeRoomEntity freeRoomEntity = new FreeRoomEntity();
            freeRoomEntity.setFreeId(i);
            freeRoomRepository.save(freeRoomEntity);
        }
        return "true";
    }
}
