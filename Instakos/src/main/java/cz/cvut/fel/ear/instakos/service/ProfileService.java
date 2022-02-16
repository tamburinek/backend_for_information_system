package cz.cvut.fel.ear.instakos.service;

import cz.cvut.fel.ear.instakos.dao.ChatDao;
import cz.cvut.fel.ear.instakos.dao.MessageDao;
import cz.cvut.fel.ear.instakos.dao.ProfileDao;
import cz.cvut.fel.ear.instakos.model.chat.Chat;
import cz.cvut.fel.ear.instakos.model.chat.Message;
import cz.cvut.fel.ear.instakos.model.profile.Profile;
import cz.cvut.fel.ear.instakos.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ProfileService {
    private final ProfileDao profileDao;
    private final ChatDao chatDao;

    @Autowired
    public ProfileService(ProfileDao profileDao, ChatDao chatDao) {
        this.profileDao = profileDao;
        this.chatDao = chatDao;
    }
    @Transactional
    public void createProfile(Profile profile){
        Objects.requireNonNull(profile);
        profileDao.persist(profile);
    }
    @Transactional
    public void createChat(Chat chat) {
        Objects.requireNonNull(chat);
        chatDao.persist(chat);
    }

    @Transactional
    public Profile findByID(int id) {
        return profileDao.find(id);
    }


}
