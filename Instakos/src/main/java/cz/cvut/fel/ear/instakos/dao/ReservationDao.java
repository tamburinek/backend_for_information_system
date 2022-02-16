package cz.cvut.fel.ear.instakos.dao;

import cz.cvut.fel.ear.instakos.model.places.Reservation;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationDao extends BaseDao<Reservation>{

    public ReservationDao() {
        super(Reservation.class);
    }
}
