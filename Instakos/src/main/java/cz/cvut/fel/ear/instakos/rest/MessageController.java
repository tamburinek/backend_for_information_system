package cz.cvut.fel.ear.instakos.rest;

import cz.cvut.fel.ear.instakos.model.chat.Message;
import cz.cvut.fel.ear.instakos.repository.MessageRepository;
import cz.cvut.fel.ear.instakos.service.ChatService;
import cz.cvut.fel.ear.instakos.service.MessageService;
import cz.cvut.fel.ear.instakos.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@Controller
public class MessageController {

    private final MessageRepository messageRepository;
    private final ChatService chatService;
    private final ProfileService profileService;
    private final MessageService messageService;


    @Autowired
    public MessageController(MessageRepository messageRepository, ChatService chatService, ProfileService profileService, MessageService messageService) {
        this.messageRepository = messageRepository;
        this.chatService = chatService;
        this.profileService = profileService;
        this.messageService = messageService;
    }

    @GetMapping("/message")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_STUDENT')")
    public String showMessageForm() {
        return "message";
    }

}
