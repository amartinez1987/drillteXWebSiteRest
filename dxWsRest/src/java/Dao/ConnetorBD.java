package Dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AnibalGuillermo
 */
class ConnetorBD {
    public static Connection getDriverManagerConnection() throws ClassNotFoundException, SQLException
    {
      Class.forName("com.mysql.jdbc.Driver");
      // Setup the connection with the DB
      String url = "jdbc:mysql://localhost:3306/drilltexbd";
      String user ="root";
      String password ="";
      Connection connect = DriverManager.getConnection(url, user, password);
      return connect;
    }
        
}
