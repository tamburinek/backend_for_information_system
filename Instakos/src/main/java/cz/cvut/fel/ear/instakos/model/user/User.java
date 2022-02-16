package cz.cvut.fel.ear.instakos.model.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import cz.cvut.fel.ear.instakos.model.AbstractEntity;
import cz.cvut.fel.ear.instakos.model.enums.Roles;
import cz.cvut.fel.ear.instakos.model.places.Reservation;
import cz.cvut.fel.ear.instakos.model.profile.Profile;
import cz.cvut.fel.ear.instakos.model.school.*;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.persistence.*;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "INSTAKOS_USER")
@NamedQueries({@NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username")
})
public class User extends AbstractEntity {


    @Basic(optional = false)
    @Column(nullable = false)
    private int age;

    @Basic(optional = false)
    @Column(nullable = false)
    private String firstName;

    @Basic(optional = false)
    @Column(nullable = false)
    private String lastName;

    @Basic(optional = false)
    @Column(nullable = false, unique = true)
    private String username;

    @Basic(optional = false)
    @Column(nullable = false)
    private String password;

    @Basic(optional = false)
    @Column(nullable = false)
    private String gender;

    @Enumerated(EnumType.STRING)
    private Roles role = Roles.GUEST;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    @OrderBy("email ASC")
    private List<Email> emails;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="ADDRESS_ID")
    private Address address;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JsonBackReference
    @JoinColumn(name="PROFILE_ID")
    private Profile profile;

    @ManyToMany
    @OrderBy("deadline")
    @JoinTable(name="USERS_HOMEWORK", joinColumns= @JoinColumn(name="USER_ID"), inverseJoinColumns= @JoinColumn(name="HOMEWORK_ID"))
    private List<Homework> homeworks;

    @OneToMany
    @OrderBy("language")
    @JoinTable(name="USERS_EXP", joinColumns= @JoinColumn(name="USER_ID"), inverseJoinColumns= @JoinColumn(name="EXP_ID"))
    private List<SkillExperience> skillExperiences;

    @ManyToMany
    @OrderBy("date")
    @JoinTable(name="USERS_EXAMS", joinColumns= @JoinColumn(name="USER_ID"), inverseJoinColumns= @JoinColumn(name="EXAM_ID"))
    private List<Exam> exams;

    @OneToOne
    @JoinColumn(name = "theses_to_write")
    private Theses thesesWriting;

    @OneToMany(mappedBy = "teacher")
    @OrderBy("name")
    private List<Theses> thesesController;

    @OneToMany
    @OrderBy("name")
    @JoinTable(name="USERS_RESULT", joinColumns= @JoinColumn(name="USER_ID"), inverseJoinColumns= @JoinColumn(name="RESULT_ID"))
    private List<StudyResult> studyResults;

    @OneToMany(mappedBy = "resUser")
    @JsonManagedReference
    @OrderBy("start")
    private List<Reservation> reservations;

    @ManyToMany
    @OrderBy("start")
    @JoinTable(name="STUDYING_COURSE",joinColumns= @JoinColumn(name="USER_ID"), inverseJoinColumns= @JoinColumn(name="COURSE_ID"))
    private List<Course> coursesAsStudent;

    @OneToMany(mappedBy = "professor")
    @OrderBy("start")
    private List<Course> coursesAsProfessor;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public String getEmail() {return emails.get(0).toString();}

    public void addEmail(Email email) {
        if (emails.isEmpty()){
            emails = new ArrayList<>();
        }
        emails.add(email);
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Homework> getHomeworks() {
        return homeworks;
    }

    public void setHomeworks(List<Homework> homeworks) {
        this.homeworks = homeworks;
    }

    public List<SkillExperience> getSkillExperiences() {
        return skillExperiences;
    }

    public void setSkillExperiences(List<SkillExperience> skillExperiences) {
        this.skillExperiences = skillExperiences;
    }

    public List<Exam> getExams() {
        return exams;
    }

    public void setExams(List<Exam> exams) {
        this.exams = exams;
    }

    public Theses getThesesWriting() {
        return thesesWriting;
    }

    public void setThesesWriting(Theses thesesWriting) {
        this.thesesWriting = thesesWriting;
    }

    public List<Theses> getThesesController() {
        return thesesController;
    }

    public void setThesesController(List<Theses> thesesController) {
        this.thesesController = thesesController;
    }

    public List<StudyResult> getStudyResults() {
        return studyResults;
    }

    public void setStudyResults(List<StudyResult> studyResults) {
        this.studyResults = studyResults;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public List<Course> getCoursesAsStudent() {
        return coursesAsStudent;
    }

    public void addCourse(Course course) {
        Objects.requireNonNull(course);
        if (coursesAsStudent == null) {
            this.coursesAsStudent = new ArrayList<>();
        }
        coursesAsStudent.add(course);
    }

    public List<Course> getCoursesAsProfessor() {
        return coursesAsProfessor;
    }

    public void setCoursesAsProfessor(List<Course> coursesAsProfessor) {
        this.coursesAsProfessor = coursesAsProfessor;
    }

    @Override
    public String toString() {
        return "User: " + username;
    }

    public void erasePassword() {
        this.password = null;
    }
}
