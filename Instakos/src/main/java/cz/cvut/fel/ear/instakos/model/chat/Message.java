package cz.cvut.fel.ear.instakos.model.chat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import cz.cvut.fel.ear.instakos.model.AbstractEntity;
import cz.cvut.fel.ear.instakos.model.profile.Profile;

import javax.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Message extends AbstractEntity {

    @Basic(optional = false)
    @Column(nullable = false)
    private String message;

    @Basic(optional = false)
    @Column(nullable = false)
    private boolean isDeleted = false;

    @Basic(optional = false)
    @Column(nullable = false)
    private LocalDateTime sentAt;

    @ManyToOne
    @JoinColumn(name = "SENDER_PROFILE_ID")
    private Profile sender;

    @ManyToOne
    @JoinColumn(name = "RECIEVER_PROFILE_ID")
    private Profile reciever;;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "CHAT_ID")
    private Chat chat;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }

    public void setSentAt() {
        this.sentAt = LocalDateTime.now();
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public void setSentAt(LocalDateTime sentAt) {
        this.sentAt = sentAt;
    }

    public Profile getSender() {
        return sender;
    }

    public void setSender(Profile sender) {
        this.sender = sender;
    }

    public Profile getReciever() {
        return reciever;
    }

    public void setReciever(Profile reciever) {
        this.reciever = reciever;
    }
}
