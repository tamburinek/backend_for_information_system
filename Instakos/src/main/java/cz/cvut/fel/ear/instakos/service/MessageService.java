package cz.cvut.fel.ear.instakos.service;

import cz.cvut.fel.ear.instakos.dao.*;
import cz.cvut.fel.ear.instakos.model.chat.Chat;
import cz.cvut.fel.ear.instakos.model.chat.Message;
import cz.cvut.fel.ear.instakos.model.profile.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class MessageService {

    private final MessageDao messageDao;
    private final ChatDao chatDao;
    private final ProfileDao senderDao;


    @Autowired
    public MessageService(MessageDao messageDao, ChatDao chatDao, ProfileDao senderDao) {
        this.messageDao = messageDao;
        this.chatDao = chatDao;
        this.senderDao = senderDao;
    }

    @Transactional
    public void persist(Message message) {
        Objects.requireNonNull(message);
        messageDao.persist(message);
    }

    @Transactional
    public void delete(Message message) {
        Objects.requireNonNull(message);
        messageDao.remove(message);
    }

    @Transactional
    public Message find(int id) {
        return messageDao.find(id);
    }

    @Transactional
    public ArrayList<Message> findAllMessageInChatById(int id) {
        ArrayList<Message> result = new ArrayList<>();
        for(Message message : messageDao.findAll()){
            if(message.getChat() == null) continue;
            if(message.getChat().getId() == id) {
                result.add(message);
            }
        }
        return result;
    }
}
