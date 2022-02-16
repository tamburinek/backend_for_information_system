package cz.cvut.fel.ear.instakos.service;

import cz.cvut.fel.ear.instakos.dao.ReservationDao;
import cz.cvut.fel.ear.instakos.dao.RoomDao;
import cz.cvut.fel.ear.instakos.dao.UserDao;
import cz.cvut.fel.ear.instakos.model.places.Reservation;
import cz.cvut.fel.ear.instakos.model.places.Room;
import cz.cvut.fel.ear.instakos.model.school.Course;
import cz.cvut.fel.ear.instakos.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Service
public class PlaceService {

    private final RoomDao roomDao;
    private final ReservationDao reservationDao;
    private final UserDao userDao;

    @Autowired
    public PlaceService(RoomDao roomDao, ReservationDao reservationDao, UserDao userDao) {
        this.roomDao = roomDao;
        this.reservationDao = reservationDao;
        this.userDao = userDao;
    }

    @Transactional
    public Reservation createReservation(String username, int id,String start, String end, String day){
        User user = userDao.findByUsername(username);
        Room room = roomDao.find(id);
        Reservation reservation = new Reservation();
        reservation.setDay(day);
        reservation.setEndReservation(Timestamp.valueOf(end));
        reservation.setStart(Timestamp.valueOf(start));
        reservation.setResUser(user);
        reservation.setRoom(room);
        reservationDao.persist(reservation);
        return reservation;
    }

    @Transactional
    public Room createRoom(String location, int roomnumber){
        Room room = new Room();
        room.setLocation(location);
        room.setRoomNumber(roomnumber);
        roomDao.persist(room);
        return room;
    }

    @Transactional
    public List<Reservation> findAllReservations(){
        return reservationDao.findAll();
    }

    @Transactional
    public List<Room> findAllRooms(){
        return roomDao.findAll();
    }
}
