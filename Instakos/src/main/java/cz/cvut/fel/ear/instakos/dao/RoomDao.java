package cz.cvut.fel.ear.instakos.dao;

import cz.cvut.fel.ear.instakos.model.places.Room;
import org.springframework.stereotype.Repository;

@Repository
public class RoomDao extends BaseDao<Room> {

    public RoomDao() {
        super(Room.class);
    }
}
