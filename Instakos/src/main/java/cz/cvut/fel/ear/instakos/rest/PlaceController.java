package cz.cvut.fel.ear.instakos.rest;

import cz.cvut.fel.ear.instakos.model.places.Reservation;
import cz.cvut.fel.ear.instakos.model.places.Room;
import cz.cvut.fel.ear.instakos.model.school.Course;
import cz.cvut.fel.ear.instakos.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/place")
public class PlaceController {

    private final PlaceService placeService;

    @Autowired
    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @PostMapping(value = "/create/reservation/{username}/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void createCourse(@PathVariable String username, @PathVariable int id,   @RequestBody HashMap<String, String> request) {
        placeService.createReservation(username,id, request.get("start"), request.get("endReservation"),request.get("day"));
    }

    @GetMapping("/all/reservation")
    public List<Reservation> getAllReservations(){
        return placeService.findAllReservations();
    }

    @PostMapping(value = "/create/room", produces = MediaType.APPLICATION_JSON_VALUE)
    public void createRoom(@RequestBody HashMap<String, String> request) {
        placeService.createRoom(request.get("location"), Integer.parseInt(request.get("room")));
    }

    @GetMapping("/all/rooms")
    public List<Room> getAllRooms(){
        return placeService.findAllRooms();
    }

}
