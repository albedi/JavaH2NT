/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ersoluciones.gila.controllers;
import com.ersoluciones.gila.apis.Response;
import com.ersoluciones.gila.apis.CategoriesResponse;
import com.ersoluciones.gila.apis.MessagesResponse;
import com.ersoluciones.gila.model.Message;
import com.ersoluciones.gila.model.UserPortal;
import com.ersoluciones.gila.services.CategoryService;
import com.ersoluciones.gila.services.MessageService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Edgar Albedi
 */
@RestController
@RequestMapping("/v1/gila")
public class GilaController {
    
  private final Logger log = LoggerFactory.getLogger(GilaController.class);
  
  @Autowired
  CategoryService categoryService;
  
  @Autowired
  MessageService messageService;
    
  @RequestMapping("/hola")
  public String doHola(){
    return "Hola Mundo";
  }
  
  @CrossOrigin(origins = "http://localhost:3000")
  @GetMapping("/categories")
  public ResponseEntity<CategoriesResponse> getCategories(){
    // Response resp = new Response(200,"OK",Arrays.asList("Java", "Python", "C++", "C", "Ruby"));
      CategoriesResponse resp = CategoriesResponse.builder()
              .code(200)
              .message("OK")
              .categories(categoryService.getAllCategory())
              .build();
    return new ResponseEntity<>(resp, HttpStatus.OK);
  }
  
  @CrossOrigin(origins = "http://localhost:3000")
  @GetMapping("/categories/{user_code}")
  public ResponseEntity<CategoriesResponse> getCategories(
          @PathVariable(value="user_code") int userCode){
      CategoriesResponse resp = CategoriesResponse.builder()
              .code(200)
              .message("OK")
              .categories(categoryService.getAllCategory(userCode))
              .build();
    return new ResponseEntity<>(resp, HttpStatus.OK);
  }
  
  @CrossOrigin(origins = "http://localhost:3000")
  @GetMapping("/messages")
  public ResponseEntity<MessagesResponse> getMessages(){
    MessagesResponse resp = MessagesResponse.builder()
            .code(200)
            .message("OK")
            .messages(messageService.getAllMessages())
            .build();
    return new ResponseEntity<>(resp, HttpStatus.OK);
  }
  
  @CrossOrigin(origins = "http://localhost:3000")
  @GetMapping("/messages/{user_code}")
  public ResponseEntity<MessagesResponse> getMessages(
          @PathVariable(value="user_code") int userCode){
    List<Message> allMessages = messageService.getAllMessages(userCode);
    allMessages.forEach(m -> m.setUserPortal(new UserPortal(m.getUserPortal().getUser_code())));
    MessagesResponse resp = MessagesResponse.builder()
            .code(200)
            .message("OK")
            .messages(allMessages)
            .build();
    return new ResponseEntity<>(resp, HttpStatus.OK);
  }
  
  @CrossOrigin(origins = "http://localhost:3000")
  @PostMapping("/message")
  public ResponseEntity<Response> postMessage(@RequestBody Message message){ 
    Message storedMessage = messageService.saveMessage(message);
    messageService.sendNotifications(storedMessage);
    log.info("FIN postMessage");
    Response resp = new Response(200,"OK");
    return new ResponseEntity<>(resp, HttpStatus.CREATED);
  }
  
  
}
