package cz.cvut.fel.ear.instakos.model.school;

import cz.cvut.fel.ear.instakos.model.AbstractEntity;
import cz.cvut.fel.ear.instakos.model.user.User;
import javax.persistence.*;


import java.text.SimpleDateFormat;
import java.util.List;

@Entity
public class Exam extends AbstractEntity {

    @Basic(optional = false)
    @Column(nullable = false)
    private String name;

    @Basic(optional = false)
    @Column(nullable = false)
    private SimpleDateFormat date;

    @Basic(optional = false)
    @Column(nullable = false)
    private int credits;

    @ManyToMany(mappedBy = "exams")
    private List<User> users;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SimpleDateFormat getDate() {
        return date;
    }

    public void setDate(SimpleDateFormat date) {
        this.date = date;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Exam: name=" + name + ", date=" + date + ", credits=" + credits;
    }

}
