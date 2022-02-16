package cz.cvut.fel.ear.instakos.service;

import cz.cvut.fel.ear.instakos.dao.UserDao;
import cz.cvut.fel.ear.instakos.model.enums.Permission;
import cz.cvut.fel.ear.instakos.model.enums.Roles;
import cz.cvut.fel.ear.instakos.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Objects;

@Service
public class UserService {

    private final UserDao dao;

    private User currentUser = new User();

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserDao dao, PasswordEncoder passwordEncoder) {
        this.dao = dao;
        this.passwordEncoder = passwordEncoder;
    }

    public String hashPassword(String password){
        return passwordEncoder.encode(password);
    }


    public boolean matches(String password, String checkPassword){
        return passwordEncoder.matches(password, checkPassword);
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User user){
        currentUser = user;
    }

    @Transactional
    public void persist(User user) {
        Objects.requireNonNull(user);
        dao.persist(user);
    }

    @Transactional
    public User findByUsername(String username) {
        return dao.findByUsername(username);
    }

    @Transactional
    public User findByID(int id) {
        return dao.find(id);
    }

    @Transactional(readOnly = true)
    public boolean exists(String username) {
        return dao.findByUsername(username) != null;
    }

    @Transactional
    public boolean blockUser(String username){
        User user = dao.findByUsername(username);
        user.setRole(Roles.BLOCKED);
        dao.persist(user);
        return true;
    }

}
