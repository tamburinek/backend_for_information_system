package cz.cvut.fel.ear.instakos.dao;

import cz.cvut.fel.ear.instakos.model.post.Comment;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDao extends BaseDao<Comment>{
    protected CommentDao() {
        super(Comment.class);
    }
}
