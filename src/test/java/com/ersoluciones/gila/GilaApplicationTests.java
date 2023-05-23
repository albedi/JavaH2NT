package com.ersoluciones.gila;

import com.ersoluciones.gila.model.Category;
import com.ersoluciones.gila.model.Message;
import com.ersoluciones.gila.model.UserPortal;
import com.ersoluciones.gila.services.MessageService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class GilaApplicationTests {

	@Test
	void contextLoads() {
	}
        
    @Autowired
    private MockMvc mockMvc;
    
    @Autowired
  MessageService messageService;
        
    @Test
    public void getCategories() throws Exception{     
        mockMvc.perform(MockMvcRequestBuilders
                .get("/v1/gila/categories")
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk());
    }
    
    @Test
    public void getCategoriesByUserCode() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders
                .get("/v1/gila/categories/{user_code}", 3)
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content()
                    .json("{\"code\": 200, \"message\": \"OK\",\"categories\": [{\"category_code\": 3,\"category_name\": \"Movies\"}]}"));
    }
    
    @Test
    public void getMessages() throws Exception{     
        mockMvc.perform(MockMvcRequestBuilders
                .get("/v1/gila/messages")
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("messages").isEmpty());
    }
    
    @Test
    public void getMessagesByUserCode() throws Exception{   
        Message testMessage = new Message();
        Category movies = new Category();
        movies.setCategory_code(3);
        testMessage.setCategory(movies);
        testMessage.setMessage("Test Message");
        testMessage.setUserPortal(new UserPortal(3));
        messageService.saveMessage(testMessage);
        mockMvc.perform(MockMvcRequestBuilders
                .get("/v1/gila/messages/{user_code}", 3)
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("messages").isNotEmpty());
    }
    
    @Test
    public void postMessage() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders
                .post("/v1/gila/message")
                .contentType("application/json")
                .content("{\"category\":{\"category_code\":3},\"message\":\"new premiers\",\"userPortal\":{\"user_code\":3,\"user_name\":\"Pruebas\"}}")
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isCreated());
    }

}
