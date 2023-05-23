/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  Edgar Albedi
 * Created: 18 may. 2023
 */

/* 
DROP TABLE IF EXISTS CATEGORIES;  
CREATE TABLE CATEGORIES (  
category_code INT AUTO_INCREMENT  PRIMARY KEY,  
category_name VARCHAR(50) NOT NULL
);  

DROP TABLE IF EXISTS MESSAGES;  
CREATE TABLE MESSAGES (  
message_code INT AUTO_INCREMENT  PRIMARY KEY,
category_code INT NOT NULL,  
message VARCHAR(50) NOT NULL
);
*/
