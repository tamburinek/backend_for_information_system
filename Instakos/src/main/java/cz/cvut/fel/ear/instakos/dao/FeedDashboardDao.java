package cz.cvut.fel.ear.instakos.dao;

import cz.cvut.fel.ear.instakos.model.post.FeedDashboard;
import org.springframework.stereotype.Repository;

@Repository
public class FeedDashboardDao extends BaseDao<FeedDashboard> {
    protected FeedDashboardDao() {
        super(FeedDashboard.class);
    }
}
