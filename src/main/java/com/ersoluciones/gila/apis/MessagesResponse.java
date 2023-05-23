/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ersoluciones.gila.apis;

import com.ersoluciones.gila.model.Message;
import java.util.List;
import lombok.Builder;
import lombok.Data;

/**
 *
 * @author Edgar Albedi
 */
@Builder
@Data
public class MessagesResponse {
    private int code;
    private String message;
    private List<Message> messages;
}
