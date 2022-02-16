package cz.cvut.fel.ear.instakos.model.profile;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import cz.cvut.fel.ear.instakos.model.AbstractEntity;
import cz.cvut.fel.ear.instakos.model.chat.Chat;
import cz.cvut.fel.ear.instakos.model.chat.Message;
import cz.cvut.fel.ear.instakos.model.post.Comment;
import cz.cvut.fel.ear.instakos.model.post.FeedDashboard;
import cz.cvut.fel.ear.instakos.model.post.Post;
import cz.cvut.fel.ear.instakos.model.user.User;
import javax.persistence.*;

import java.util.List;

@Entity
public class Profile extends AbstractEntity {

    @Basic(optional = false)
    @Column(nullable = false)
    private String bio;

    @OneToOne(mappedBy = "profile")
    @JsonBackReference
    private User user;

    @OneToOne
    @JoinColumn(name = "FEEDDB_ID")
    private FeedDashboard feedDashboard;

    @OneToMany(mappedBy = "createBy")
    private List<Post> posts;

    @OneToMany
    @JoinTable(name = "PROFILE_FOLLOWERS",
            joinColumns = @JoinColumn(name = "PROFILE_ID"),
            inverseJoinColumns = @JoinColumn(name = "FOLLOWER_ID")
    )
    private List<Profile> followers;


    @OneToMany(mappedBy = "createBy")
    private List<Comment> comments;

    @OneToMany(mappedBy="sender")
    private List<Message> sentMessages;

    @OneToMany(mappedBy="reciever")
    private List<Message> recievedMessages;

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public FeedDashboard getFeedDashboard() {
        return feedDashboard;
    }

    public void setFeedDashboard(FeedDashboard feedDashboard) {
        this.feedDashboard = feedDashboard;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Profile> getFollowers() {
        return followers;
    }

    public void setFollowers(List<Profile> followers) {
        this.followers = followers;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
