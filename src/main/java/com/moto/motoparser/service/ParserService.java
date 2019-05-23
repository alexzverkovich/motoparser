package com.moto.motoparser.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.sql.Connection;
import java.sql.DriverManager;

@Service
public class ParserService {

    Logger log = Logger.getLogger(ParserService.class);

    public String parseFile(CommonsMultipartFile file){

        String uploadResult = "Conn not tested...";

        try{
            String url = "jdbc:mysql://localhost/store";
            String username = "root";
            String password = "20Sasha18*";
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                log.info("Connection to Store DB successful!");
                uploadResult = "Connection to Store DB successful!";
            }
        }
        catch(Exception e){
            log.error("Connection failed...");
            log.error(e);
            uploadResult = e.getMessage();
            return uploadResult;
        }




        return uploadResult;
    }
}
