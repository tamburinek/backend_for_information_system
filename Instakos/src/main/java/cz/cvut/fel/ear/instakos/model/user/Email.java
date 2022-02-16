package cz.cvut.fel.ear.instakos.model.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import cz.cvut.fel.ear.instakos.model.AbstractEntity;

import javax.persistence.*;


@Entity
@Table(name = "EMAIL")
@NamedQueries({@NamedQuery(name = "Email.findByEmail", query = "SELECT u FROM Email u WHERE u.email = :email")
})
public class Email extends AbstractEntity {

    @Basic(optional = false)
    @Column(nullable = false, unique = true)
    private String email;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(nullable = false, name = "USER_OF_EMAIL")
    private User user;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Email{" +
                "email='" + email + '\'' +
                ", user=" + user +
                '}';
    }
}
