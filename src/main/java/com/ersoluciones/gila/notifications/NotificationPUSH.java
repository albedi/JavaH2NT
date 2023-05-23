/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ersoluciones.gila.notifications;

import com.ersoluciones.gila.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Edgar Albedi
 */
public class NotificationPUSH extends Notification {
    
    private final Logger log = LoggerFactory.getLogger(NotificationPUSH.class);

    public NotificationPUSH() {
        super();
    }
    
    public NotificationPUSH(Message message) {
        super(message);
    }

    @Override
    public void send() {
        log.info("NOTIFICATION ::: PUSH");
    }
    
}
