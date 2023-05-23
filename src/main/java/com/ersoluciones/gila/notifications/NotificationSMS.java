/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ersoluciones.gila.notifications;

import com.ersoluciones.gila.model.Message;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Edgar Albedi
 */
@Data
public class NotificationSMS extends Notification {
    
    private final Logger log = LoggerFactory.getLogger(NotificationSMS.class);
    
    private String phone_number;

    public NotificationSMS() {
        super();
    }
    
    public NotificationSMS(Message message, String phone_number) {
        super(message);
        this.phone_number = phone_number;
    }
    
    public NotificationSMS(Message message) {
        super(message);
    }

    @Override
    public void send() {
        log.info("NOTIFICATION ::: SMS ({})", this.phone_number);
    }
    
}
