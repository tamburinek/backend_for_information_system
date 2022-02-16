package cz.cvut.fel.ear.instakos.service;

import cz.cvut.fel.ear.instakos.dao.ChatDao;
import cz.cvut.fel.ear.instakos.dao.MessageDao;
import cz.cvut.fel.ear.instakos.dao.ProfileDao;
import cz.cvut.fel.ear.instakos.model.chat.Chat;
import cz.cvut.fel.ear.instakos.model.chat.Message;
import cz.cvut.fel.ear.instakos.model.profile.Profile;
import cz.cvut.fel.ear.instakos.security.SecurityUtils;
import cz.cvut.fel.ear.instakos.security.model.AuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ChatService {

    private final ProfileDao profileDao;
    private final MessageDao messageDao;
    private final ChatDao chatDao;


    @Autowired
    public ChatService(ProfileDao profileDao, MessageDao messageDao, ChatDao chatDao) {
        this.profileDao = profileDao;
        this.messageDao = messageDao;
        this.chatDao = chatDao;
    }

    @Transactional
    public void removeMessage(Message message) {
        Objects.requireNonNull(message);
        message.setDeleted(true);
        messageDao.update(message);
    }

    @Transactional
    public void sendMessage(Message message) {
        Objects.requireNonNull(message);
        messageDao.persist(message);
    }

    @Transactional
    public void createChat(Chat chat) {
        Objects.requireNonNull(chat);
        chatDao.persist(chat);
    }

    @Transactional
    public Chat findChat(Message message) {
        return chatDao.find(message.getChat().getId());
    }

    @Transactional
    public List<Chat> findAllChat() {
        return chatDao.findAll();
    }

    @Transactional
    public Chat findChatById(int id) {
        return chatDao.find(id);
    }

    @Transactional
    public List<Chat> findAllChatOfUser(int ID) {
        List<Chat> result = new ArrayList<>();
        for(Chat chat : chatDao.findAll()){
            if(chat.getProfile1().getId() == ID || chat.getProfile2().getId() == ID ){
                result.add(chat);
            }
        }
        return result;
    }
}
