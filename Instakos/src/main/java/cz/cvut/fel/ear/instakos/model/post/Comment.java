package cz.cvut.fel.ear.instakos.model.post;

import cz.cvut.fel.ear.instakos.model.AbstractEntity;
import cz.cvut.fel.ear.instakos.model.profile.Profile;

import javax.persistence.*;


import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Comment extends AbstractEntity {

    @Basic(optional = false)
    @Column(nullable = false)
    private LocalDateTime createAt;

    @Basic(optional = false)
    @Column(nullable = false)
    private String comment;

    @ManyToOne
    @JoinColumn(name = "PROFILE_ID")
    private Profile createBy;

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt() {
        this.createAt = LocalDateTime.now();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Profile getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Profile createBy) {
        this.createBy = createBy;
    }

}
