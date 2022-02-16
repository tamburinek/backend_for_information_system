package cz.cvut.fel.ear.instakos.model.school;

import cz.cvut.fel.ear.instakos.model.AbstractEntity;
import javax.persistence.*;

import java.text.SimpleDateFormat;

@Entity
public class Homework extends AbstractEntity {

    @Basic(optional = false)
    @Column(nullable = false)
    private SimpleDateFormat deadline;

    @Basic(optional = false)
    @Column(nullable = false)
    private int points;

    @Basic(optional = false)
    @Column(nullable = false)
    private boolean compulsory;

    public SimpleDateFormat getDeadline() {
        return deadline;
    }

    public void setDeadline(SimpleDateFormat deadline) {
        this.deadline = deadline;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public boolean isCompulsory() {
        return compulsory;
    }

    public void setCompulsory(boolean compulsory) {
        this.compulsory = compulsory;
    }

    @Override
    public String toString() {
        return "Homework for " + points + " is until " + deadline + " and is compulsory: " + compulsory;
    }
}
