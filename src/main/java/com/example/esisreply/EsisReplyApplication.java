package com.example.esisreply;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.*;

@SpringBootApplication
public class EsisReplyApplication {

    public static void main(String[] args) {
        //SpringApplication.run(EsisReplyApplication.class, args);
        SpringApplication app = new SpringApplication(EsisReplyApplication.class);

        //Application.Properties
        String DB_DRIVER_URL = "com.mysql.cj.jdbc.Driver";
        String DB_URL = "jdbc:mysql://127.0.0.3:3306/esis_reply_db";
        String DB_USERNAME ="root";
        String DB_PASSWORD ="Root92";
        Integer SERVER_PORT =9002;

        //Mappiamo le properties dentro l'ogetto "props"
        Map<String, Object> props = new HashMap<>();
        props.put("spring.datasource.driver-class-name", DB_DRIVER_URL);
        props.put("spring.datasource.url", DB_URL);
        props.put("spring.datasource.username", DB_USERNAME);
        props.put("spring.datasource.password", DB_PASSWORD);
        props.put("server.port", SERVER_PORT);
        app.setDefaultProperties(props);
        app.run(args);
    }

}