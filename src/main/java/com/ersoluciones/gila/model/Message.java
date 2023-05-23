/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ersoluciones.gila.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;


/**
 *
 * @author Edgar Albedi
 */
@Entity
@Table
@Data
public class Message {
    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int message_code;
    
    @ManyToOne
    @JoinColumn(name = "user_code")
    private UserPortal userPortal;
    
    @ManyToOne
    @JoinColumn(name ="category_code")
    private Category category;
    
    @Column
    private String message;
    
}
