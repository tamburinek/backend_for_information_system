package cz.cvut.fel.ear.instakos.model.chat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import cz.cvut.fel.ear.instakos.model.AbstractEntity;
import cz.cvut.fel.ear.instakos.model.profile.Profile;

import javax.persistence.*;


import java.util.List;

@Entity
public class Chat extends AbstractEntity {

    @OneToMany(mappedBy="chat")
    @JsonManagedReference
    private List<Message> messages;

    @ManyToOne
    @JoinColumn(name="PROFILE1_ID")
    private Profile profile1;

    @ManyToOne
    @JoinColumn(name="PROFILE2_ID")
    private Profile profile2;

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public Profile getProfile1() {
        return profile1;
    }

    public void setProfile1(Profile profile1) {
        this.profile1 = profile1;
    }

    public Profile getProfile2() {
        return profile2;
    }

    public void setProfile2(Profile profile2) {
        this.profile2 = profile2;
    }
}
