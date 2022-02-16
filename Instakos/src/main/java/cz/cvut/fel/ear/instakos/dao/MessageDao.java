package cz.cvut.fel.ear.instakos.dao;

import cz.cvut.fel.ear.instakos.model.chat.Message;
import org.springframework.stereotype.Repository;

@Repository
public class MessageDao extends BaseDao<Message>{
    protected MessageDao() {
        super(Message.class);
    }
}
