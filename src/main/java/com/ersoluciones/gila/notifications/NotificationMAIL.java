/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ersoluciones.gila.notifications;

import com.ersoluciones.gila.model.Message;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Edgar Albedi
 */
@Data
public class NotificationMAIL extends Notification {
    
    private final Logger log = LoggerFactory.getLogger(NotificationMAIL.class);

    private String email;
    
    public NotificationMAIL() {
        super();
    }
    
    public NotificationMAIL(Message message, String email){
        super(message);
        this.email = email;
    }
    
    public NotificationMAIL(Message message) {
        super(message);
    }
    
    @Override
    public void send() {
        log.info("NOTIFICATION ::: MAIL ({})", this.email);
    }
    
}
