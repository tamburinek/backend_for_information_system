package cz.cvut.fel.ear.instakos.rest;

import cz.cvut.fel.ear.instakos.model.chat.Chat;
import cz.cvut.fel.ear.instakos.model.chat.Message;
import cz.cvut.fel.ear.instakos.service.ChatService;
import cz.cvut.fel.ear.instakos.service.MessageService;
import cz.cvut.fel.ear.instakos.service.ProfileService;
import cz.cvut.fel.ear.instakos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/chat")
public class ChatController {

    private final UserService userService;
    private final ChatService chatService;
    private final ProfileService profileService;
    private final MessageService messageService;


    @Autowired
    public ChatController(UserService userService, ChatService chatService, ProfileService profileService, MessageService messageService) {
        this.userService = userService;
        this.chatService = chatService;
        this.profileService = profileService;
        this.messageService = messageService;
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") int id) {
        messageService.delete(messageService.find(id));
        System.out.println("smazano");
    }

    @GetMapping("/{id}")
    public ArrayList<Message> getAllMessage(@PathVariable int id) {
        return messageService.findAllMessageInChatById(id);
    }

    @PostMapping(value = "/{id}/send", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_STUDENT', 'ROLE_TEACHER')")
    public void sendMessage(@PathVariable int id, Principal principal,
                            @RequestParam("message") String messageToSent) {
        Chat chat = chatService.findChatById(id);

        Message message = new Message();

        message.setMessage(messageToSent);
        message.setSentAt();
        message.setChat(chat);
        message.setSender(userService.findByUsername(principal.getName()).getProfile());
        if (chatService.findChatById(id).getProfile1() == userService.findByUsername(principal.getName()).getProfile()){
            message.setReciever(chatService.findChatById(id).getProfile2());
        } else {
            message.setReciever(chatService.findChatById(id).getProfile1());
        }

        chatService.sendMessage(message);
    }

    @GetMapping("/allChat")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_STUDENT', 'ROLE_TEACHER')")
    public List<Chat> getAllChatsOfUSer(Principal principal) {
        return chatService.findAllChatOfUser(userService.findByUsername(principal.getName()).getProfile().getId());
    }

    @GetMapping("/{id}/name")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_STUDENT', 'ROLE_TEACHER')")
    public String getChatSecondUser(Principal principal, @PathVariable int id) {
        if (chatService.findChatById(id).getProfile1() == userService.findByUsername(principal.getName()).getProfile()) {
            return (chatService.findChatById(id).getProfile2().getUser().getUsername());
        } else {
            return (chatService.findChatById(id).getProfile1().getUser().getUsername());
        }
    }

    @PostMapping(value = "/newChat", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_STUDENT', 'ROLE_TEACHER')")
    public int createNewChat(Principal principal,
                              @RequestParam("username") String username,
                              @RequestParam("message") String messageToSend
    ) {
        Chat chat = new Chat();
        chat.setProfile1(userService.findByUsername(principal.getName()).getProfile());
        chat.setProfile2(userService.findByUsername(username).getProfile());

        chatService.createChat(chat);

        Message message = new Message();
        message.setMessage(messageToSend);
        message.setSentAt();
        message.setChat(chat);

        message.setSender(userService.findByUsername(principal.getName()).getProfile());
        message.setReciever(userService.findByUsername(username).getProfile());

        messageService.persist(message);

        return chatService.findChat(message).getId();
    }

}
