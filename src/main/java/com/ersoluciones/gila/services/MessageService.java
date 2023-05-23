/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ersoluciones.gila.services;

import com.ersoluciones.gila.model.Message;
import com.ersoluciones.gila.model.UserPortal;
import com.ersoluciones.gila.notifications.NotificationPool;
import com.ersoluciones.gila.respositories.CategoryRepository;
import com.ersoluciones.gila.respositories.MessageRepository;
import com.ersoluciones.gila.respositories.UserPortalRepository;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Edgar Albedi
 */
@Service
public class MessageService {
    
    private final Logger log = LoggerFactory.getLogger(MessageService.class);
    
    @Autowired
    MessageRepository repository;
    @Autowired
    CategoryRepository categoryRepo;
    @Autowired
    UserPortalRepository userPortalRepo;
    
    public List<Message> getAllMessages() {  
        List<Message> messages = new ArrayList<>();  
        repository.findAll().forEach(messages::add);  
        return messages;  
    }
    
    public List<Message> getAllMessages(int user_code) { 
        return repository.findByUserPortal(new UserPortal(user_code));
    }
    
    public Message saveMessage(Message message) {
        return repository.save(message);
    }
    
    public void sendNotifications(Message message){
        Message preparedMessage = repository
                .findById(message.getMessage_code()).get();
        UserPortal userPortal = userPortalRepo
                .findById(preparedMessage.getUserPortal()
                        .getUser_code()).get();
        preparedMessage.setUserPortal(userPortal);
        preparedMessage.setCategory(categoryRepo
                .findById(preparedMessage.getCategory()
                        .getCategory_code()).get());
        
        log.info(preparedMessage.getUserPortal().toString());
        log.info(userPortal.getChannels().toString());
        log.info(preparedMessage.getCategory().toString());
        log.info(preparedMessage.toString());
        NotificationPool pool = new NotificationPool();
        pool.setMessage(message);
        pool.setUserPortal(userPortal);
        pool.subscribe(userPortal.getChannels());
        // pool.subscribe(new NotificationSMS());
        // pool.subscribe(new NotificationMAIL());
        // pool.subscribe(new NotificationPUSH());
        pool.sendAll();
    }
    
}
