package cz.cvut.fel.ear.instakos.repository;

import cz.cvut.fel.ear.instakos.model.chat.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository  extends JpaRepository<Message, Long> {
}
