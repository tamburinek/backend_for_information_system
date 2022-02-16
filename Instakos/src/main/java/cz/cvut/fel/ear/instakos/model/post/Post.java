package cz.cvut.fel.ear.instakos.model.post;

import cz.cvut.fel.ear.instakos.model.AbstractEntity;
import cz.cvut.fel.ear.instakos.model.profile.Profile;

import javax.persistence.*;


import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Post extends AbstractEntity {

    @Basic(optional = false)
    @Column(nullable = false)
    private LocalDateTime createAt;

    @Basic(optional = false)
    @Column(nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "PROFILE_ID")
    private Profile createBy;

    @OneToMany
    @JoinTable(name = "POST_COMMENT",
            joinColumns = @JoinColumn(name = "POST_ID"),
            inverseJoinColumns = @JoinColumn(name = "COMMENT_ID"))
    private List<Comment> comments;


    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt() {
        this.createAt = LocalDateTime.now();
    }

    public Profile getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Profile createBy) {
        this.createBy = createBy;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public void removeComment(Comment comment) {
        comments.remove(comment);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
