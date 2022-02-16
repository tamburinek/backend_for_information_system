package cz.cvut.fel.ear.instakos.dao;

import cz.cvut.fel.ear.instakos.model.chat.Chat;
import org.springframework.stereotype.Repository;

@Repository
public class ChatDao extends BaseDao<Chat>{

    public ChatDao() {
        super(Chat.class);
    }
}
