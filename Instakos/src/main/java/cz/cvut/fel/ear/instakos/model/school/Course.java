package cz.cvut.fel.ear.instakos.model.school;

import com.fasterxml.jackson.annotation.JsonIgnore;
import cz.cvut.fel.ear.instakos.model.AbstractEntity;
import cz.cvut.fel.ear.instakos.model.user.User;
import javax.persistence.*;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Course extends AbstractEntity {

    @Basic(optional = false)
    @Column(nullable = false)
    private String name;

    @Basic(optional = false)
    @Column(nullable = false)
    private Time start;

    @Basic(optional = false)
    @Column(nullable = false)
    private Time endTime;

    @Basic(optional = false)
    @Column(nullable = false)
    private String day;

    @Basic(optional = false)
    @Column(nullable = false)
    private int capacity;

    @ManyToMany(mappedBy = "coursesAsStudent")
    @OrderBy("lastName")
    @JsonIgnore
    private List<User> students;

    @ManyToOne
    @JoinColumn(name="DEPT_ID")
    private User professor;

    public void addStudent(User studentUser) {
        Objects.requireNonNull(studentUser);
        if (students == null) {
            this.students = new ArrayList<>();
        }
        students.add(studentUser);
        studentUser.addCourse(this);
    }

    public List<User> getStudents() {
        return students;
    }

    public void setStudents(List<User> students) {
        this.students = students;
    }

    public Time getStart() {
        return start;
    }

    public void setStart(Time start) {
        this.start = start;
    }

    public Time getEnd() {
        return endTime;
    }

    public void setEnd(Time end) {
        this.endTime = end;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getStudentsSize() {
        return students.size();
    }

    public User getProfessor() {
        return professor;
    }

    public void setProfessor(User professor) {
        this.professor = professor;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", start=" + start +
                ", end=" + endTime +
                ", day=" + day +
                '}';
    }
}
