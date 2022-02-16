package cz.cvut.fel.ear.instakos.service;


import cz.cvut.fel.ear.instakos.dao.EmailDao;
import cz.cvut.fel.ear.instakos.model.places.Room;
import cz.cvut.fel.ear.instakos.model.user.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
public class EmailService {

    private final EmailDao emailDao;


    @Autowired
    public EmailService(EmailDao emailDao) {
        this.emailDao = emailDao;
    }

    @Transactional
    public void persist(Email email) {
        Objects.requireNonNull(email);
        emailDao.persist(email);
    }
}
