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
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Edgar Albedi
 */
@Entity
@Table
@Data
@NoArgsConstructor
public class UserPortal {
    
    public UserPortal(int user_code){
        this.user_code = user_code;
    }

    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int user_code;
    
    @Column
    private String user_name;
    
    @Column
    private String phone_number;
    
    @Column
    private String email;
    
    @ManyToMany
    @JoinTable(
        name = "user_portal_channel", 
        joinColumns = { @JoinColumn(name = "user_code") }, 
        inverseJoinColumns = { @JoinColumn(name = "channel_code") }
    )
    private Set<Channel> channels = new HashSet<>();
    
    @ManyToMany
    @JoinTable(
        name = "user_portal_category", 
        joinColumns = { @JoinColumn(name = "user_code") }, 
        inverseJoinColumns = { @JoinColumn(name = "category_code") }
    )
    private Set<Category> categories = new HashSet<>();
    
}
