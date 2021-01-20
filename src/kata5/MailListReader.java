/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata5;


import kata5.model.Mail;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MailListReader {

    static List<Mail> read(String fileName) throws FileNotFoundException, ClassNotFoundException, SQLException {
        List<Mail> list = new ArrayList<>();
        
        Class.forName("org.sqlite.JDBC");
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:data/people.db");
                Statement statement = connection.createStatement()) {
             ResultSet set = statement.executeQuery("SELECT * FROM people");
             while (set.next()) {
                 String email = set.getString("email");
                 if (Mail.isMail(email))
                 list.add(new Mail(email));
             }
        }
        return list;
    }
}