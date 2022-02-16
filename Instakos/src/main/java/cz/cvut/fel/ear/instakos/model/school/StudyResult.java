package cz.cvut.fel.ear.instakos.model.school;

import cz.cvut.fel.ear.instakos.model.AbstractEntity;
import cz.cvut.fel.ear.instakos.model.user.User;
import javax.persistence.*;


import java.util.List;

@Entity
public class StudyResult extends AbstractEntity {

    @Basic(optional = false)
    @Column(nullable = false)
    private int credits;

    @Basic(optional = false)
    @Column(nullable = false)
    private String name;

    @Basic(optional = false)
    @Column(nullable = false)
    private boolean done;

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "StudyResult{" +
                "credits=" + credits +
                ", name='" + name + '\'' +
                ", done=" + done +
                '}';
    }
}
