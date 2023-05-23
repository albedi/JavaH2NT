/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ersoluciones.gila.notifications;

import com.ersoluciones.gila.model.Category;
import com.ersoluciones.gila.model.Channel;
import com.ersoluciones.gila.model.Message;
import com.ersoluciones.gila.model.UserPortal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import lombok.Data;

/**
 *
 * @author Edgar Albedi
 */
@Data
public class NotificationPool {
    
    private Message message;
    private UserPortal userPortal;
    private List<Notification> list = new ArrayList<>();
    
    public void subscribe(Set<Channel> list){
        subscribe(new ArrayList<>(list));
    }
    
    public void subscribe(List<Channel> list){
        list.forEach(c -> {
            switch (c.getChannel_code()) {
                case 1 -> {
                    subscribe(new NotificationSMS(this.message
                            , this.userPortal.getPhone_number()));
                }
                case 2 -> {
                    subscribe(new NotificationMAIL(this.message
                            , this.userPortal.getEmail()));
                }
                case 3 -> {
                    subscribe(new NotificationPUSH(this.message));
                }
                default -> throw new AssertionError();
            }
        });
    }
    
    public void subscribe(Notification notification){
        notification.setMessage(message);
        this.list.add(notification);
    }
    
    public void sendAll(){
        this.list.forEach(n -> n.start());
    }
}
