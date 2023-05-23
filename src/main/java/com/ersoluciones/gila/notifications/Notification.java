/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ersoluciones.gila.notifications;

import com.ersoluciones.gila.model.Message;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 *
 * @author Edgar Albedi
 */
@AllArgsConstructor
@NoArgsConstructor
public abstract class Notification extends Thread{
    
    private Message message; 
    
    public void setMessage(Message message){
        this.message = message;
    }
    
    public Message getMessage(){
        return this.message;
    }
    
    public abstract void send();
    
    @Override
    public void run(){
        this.send();
    }
    
}
