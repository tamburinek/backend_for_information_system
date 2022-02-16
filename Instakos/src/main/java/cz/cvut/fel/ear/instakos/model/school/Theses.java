package cz.cvut.fel.ear.instakos.model.school;

import cz.cvut.fel.ear.instakos.model.AbstractEntity;
import cz.cvut.fel.ear.instakos.model.user.User;
import javax.persistence.*;


@Entity
public class Theses extends AbstractEntity {

    @Basic(optional = false)
    @Column(nullable = false)
    private String name;

    @OneToOne(mappedBy = "thesesWriting")
    private User student;

    @ManyToOne
    @JoinColumn(name="controller")
    private User teacher;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getStudent() {
        return student;
    }

    public void setStudent(User student) {
        this.student = student;
    }

    public User getTeacher() {
        return teacher;
    }

    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Theses{" +
                "name='" + name + '\'' +
                ", student=" + student +
                ", teacher=" + teacher +
                '}';
    }
}
