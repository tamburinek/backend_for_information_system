package cz.cvut.fel.ear.instakos.model.places;

import com.fasterxml.jackson.annotation.JsonBackReference;
import cz.cvut.fel.ear.instakos.model.AbstractEntity;
import cz.cvut.fel.ear.instakos.model.user.User;
import javax.persistence.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

@Entity
public class Reservation extends AbstractEntity {

    @Basic(optional = false)
    @Column(nullable = false)
    private Timestamp start;

    @Basic(optional = false)
    @Column(nullable = false)
    private Timestamp endReservation;

    @Basic(optional = false)
    @Column(nullable = false)
    private String day;

    @ManyToOne
    @JoinColumn(name="RESERVATION_ID")
    private Room room;

    @ManyToOne
    @JoinColumn(name="USER_ID")
    @JsonBackReference
    private User resUser;

    public Timestamp getStart() {
        return start;
    }

    public void setStart(Timestamp start) {
        this.start = start;
    }

    public Timestamp getEndReservation() {
        return endReservation;
    }

    public void setEndReservation(Timestamp endReservation) {
        this.endReservation = endReservation;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Timestamp getEnd() {
        return endReservation;
    }

    public void setEnd(Timestamp end) {
        this.endReservation = end;
    }


    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public User getResUser() {
        return resUser;
    }

    public void setResUser(User resUser) {
        this.resUser = resUser;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "start=" + start +
                ", end=" + endReservation +
                ", day=" + day +
                ", room=" + room +
                ", user=" + resUser +
                '}';
    }
}
