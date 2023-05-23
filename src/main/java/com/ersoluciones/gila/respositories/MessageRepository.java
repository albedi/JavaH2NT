/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ersoluciones.gila.respositories;

import com.ersoluciones.gila.model.Message;
import com.ersoluciones.gila.model.UserPortal;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Edgar Albedi
 */
public interface MessageRepository extends CrudRepository<Message, Integer>{
    
    public List<Message> findByUserPortal(UserPortal userPortal);
    
}
