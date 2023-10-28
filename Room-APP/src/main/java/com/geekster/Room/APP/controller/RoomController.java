package com.geekster.Room.APP.controller;

import com.geekster.Room.APP.model.Room;
import com.geekster.Room.APP.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@RestController
public class RoomController {

    @Autowired
    RoomService roomService;


    //Post API
    @PostMapping("room")
    public String addRoom(@RequestBody Room newRoom){
        return roomService.addRoom(newRoom);
    }


    //add multiple rooms at once :
    @PostMapping("rooms")
    public String addRooms(@RequestBody List<Room> newRooms){
        return roomService.addRooms(newRooms);
    }


    //Get by ID :
    @GetMapping("room/id/{id}")
    public Room getRoomById(@PathVariable Integer id){
        return roomService.getRoomById(id);
    }


    //Get By Price :
    @GetMapping("room/price/{price}")
    public List<Room> getRoomByPrice(@PathVariable double price){
        return roomService.getRoomByPrice(price);
    }


    //Get Rooms which are available and are of price 5000.0 :
    @GetMapping("room/price/{price}/and/available")
    public List<Room> getAvailableRoomsByPrice(@PathVariable double price){
        return roomService.getAvailableRoomsByPrice(price);
    }


    @GetMapping("room/price/{price}/or/available")
    public List<Room> getAvailableRoomsOrByPrice(@PathVariable double price){
        return roomService.getAvailableRoomsOrByPrice(price);
    }


    @GetMapping("room/AC/or/available")
    public List<Room> getAvailableRoomsOrAcSortedByPrice(){
        return roomService.getAvailableRoomsOrAcSortedByPrice();
    }


    @GetMapping("room/AC/and/available")
    public List<Room> getAvailableRoomsAndAcSortedByPrice(){
        return roomService.getAvailableRoomsAndAcSortedByPrice();
    }

    //Get API
    @GetMapping("rooms")
    public List<Room> getRooms(){
        return roomService.getRooms();
    }


    //Delete All By IDs :
    @DeleteMapping("rooms/ids")
    public String deleteRoomsByIds(@RequestBody List<Integer> ids){
        return roomService.deleteRoomsByIds(ids);
    }


    //Delete By ID :
    @DeleteMapping("room/id/{id}")
    public String deleteRoomById(@PathVariable Integer id){
        return roomService.deleteRoomById(id);
    }

    @GetMapping("Mainak")
    public String getTest(){
        return "Mainak";
    }


    //Delete by Entity
    /*@DeleteMapping("room")
    public String deleteRoomByEntity(@PathVariable Integer id){
        return roomService.deleteRoomByEntity(id);
    }*/
}
