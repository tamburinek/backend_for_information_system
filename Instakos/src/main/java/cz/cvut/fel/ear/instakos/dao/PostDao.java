package cz.cvut.fel.ear.instakos.dao;

import cz.cvut.fel.ear.instakos.model.post.Post;
import org.springframework.stereotype.Repository;

@Repository
public class PostDao extends BaseDao<Post> {
    protected PostDao() {
        super(Post.class);
    }
}
