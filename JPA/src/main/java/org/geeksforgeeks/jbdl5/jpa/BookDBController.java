//package org.geeksforgeeks.jbdl5.jpa;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//@RestController
//public class BookDBController {
//
//    @Autowired
//    ConnectionClass connectionClass;
//
//    @Value("{db.url}")
//    private String connectionUrl;
//
//    @Value("{db.user}")
//    private String user;
//
//    @Value("{db.pass}")
//    private String password;
//
//    @PostMapping("/insert2")
//    public void insertInOtherDB() throws SQLException {
//
//        connectionClass.getConnectionForDB(connectionUrl, user, password);
//    }
//
//}
