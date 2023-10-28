package com.geekster.Room.APP.service;

import com.geekster.Room.APP.model.Room;
import com.geekster.Room.APP.model.Type;
import com.geekster.Room.APP.repo.IRoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    @Autowired
    IRoomRepo roomRepo;
    public String addRoom(Room newRoom) {
        roomRepo.save(newRoom);
        return "added!";
    }

    public List<Room> getRooms() {
        return (List<Room>) roomRepo.findAll();
    }

    public String addRooms(List<Room> newRooms) {
        roomRepo.saveAll(newRooms);
        return newRooms.size() + " were added!";
    }

    public Room getRoomById(Integer id) {
        return roomRepo.findById(id).get();
    }

    public String deleteRoomsByIds(List<Integer> ids) {
        roomRepo.deleteAllById(ids);
        return "Removed rooms.";
    }

    public String deleteRoomById(Integer id) {
        roomRepo.deleteById(id);
        return id+" removed";
    }

    public List<Room> getRoomByPrice(double price) {
        return roomRepo.findByRoomPrice(price);
    }

    public List<Room> getAvailableRoomsByPrice(double price) {
        return roomRepo.findByRoomPriceLessThanEqualAndRoomAvailable(price, true);
    }

    public List<Room> getAvailableRoomsOrByPrice(double price) {
        return roomRepo.findByRoomPriceLessThanEqualOrRoomAvailable(price, true);
    }

    public List<Room> getAvailableRoomsOrAcSortedByPrice() {
        return roomRepo.findByRoomTypeOrRoomAvailableOrderByRoomPrice(Type.AC,true);
    }

    public List<Room> getAvailableRoomsAndAcSortedByPrice() {
        return roomRepo.findByRoomTypeAndRoomAvailableOrderByRoomPrice(Type.AC,true);
    }

    /*public String deleteRoomByEntity(Integer id) {

    }*/
}
