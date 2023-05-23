/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ersoluciones.gila.services;

import com.ersoluciones.gila.model.Category;
import com.ersoluciones.gila.model.UserPortal;
import com.ersoluciones.gila.respositories.CategoryRepository;
import com.ersoluciones.gila.respositories.UserPortalRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Edgar Albedi
 */
@Service
public class CategoryService {
    
    @Autowired
    CategoryRepository repository;  
    
    @Autowired
    UserPortalRepository userPortalRepo;
    
    public List<Category> getAllCategory() {  
        List<Category> categories = new ArrayList<>();  
        repository.findAll().forEach(category -> categories.add(category));  
        return categories;  
    }  
    
    public List<Category> getAllCategory(int userCode) {  
        UserPortal userPortal = userPortalRepo
                .findById(userCode).get();
        return new ArrayList(userPortal.getCategories());
    } 
    
}
