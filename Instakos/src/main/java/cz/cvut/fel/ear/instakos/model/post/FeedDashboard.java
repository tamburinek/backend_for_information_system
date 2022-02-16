package cz.cvut.fel.ear.instakos.model.post;

import cz.cvut.fel.ear.instakos.model.AbstractEntity;
import cz.cvut.fel.ear.instakos.model.profile.Profile;

import javax.persistence.*;


import java.util.List;

@Entity
public class FeedDashboard extends AbstractEntity {

    @OneToMany
    @JoinTable(name = "FEEDDASHBOARD_POST",
            joinColumns = @JoinColumn(name = "FEEDDB_ID"),
            inverseJoinColumns = @JoinColumn(name = "POST_ID"))
    private List<Post> posts;

    @OneToOne(mappedBy = "feedDashboard")
    private Profile profile;

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public void addPost(Post post) {
        posts.add(post);
    }

    public void removePost(Post post) {
        posts.remove(post);
    }
}
