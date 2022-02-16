package cz.cvut.fel.ear.instakos.model.places;

import cz.cvut.fel.ear.instakos.model.AbstractEntity;
import javax.persistence.*;


@Entity
public class Room extends AbstractEntity {

    @Basic(optional = false)
    @Column(nullable = false)
    private int roomNumber;

    @Basic(optional = false)
    @Column(nullable = false)
    private String location;

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber=" + roomNumber +
                ", location='" + location +
                '}';
    }
}
