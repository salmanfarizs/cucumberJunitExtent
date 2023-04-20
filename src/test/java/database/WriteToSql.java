package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.junit.Test;

import hooks.Hooks;

public class WriteToSql {
	
	
	//@Test
	public static void updateMetrics() {
	
	Connection conn = null;
    Statement stmt = null;
    try {
       try {
          Class.forName("com.mysql.jdbc.Driver");
       } catch (Exception e) {
          System.out.println(e);
    }
       
       
       DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");  
       LocalDateTime now = LocalDateTime.now();  
       System.out.println(dtf.format(now));  
       
    conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "vento@786");
    System.out.println("Connection is created successfully:");
    
    
    stmt = (Statement) conn.createStatement();
    
    String query1 = "use Emirates_TestDB";
    stmt.executeUpdate(query1);
    System.out.println("DB choosen successfully");

    String query2 = "INSERT INTO TestResults " + "VALUES ('EMIRATES_001', '"+Hooks.scnearioStatus+"', '"+Hooks.scenarioname+"' ,'Salman', '"+dtf.format(now)+"')";
    stmt.executeUpdate(query2);
   
    System.out.println("Record is inserted in the metrics table successfully");
    } catch (SQLException excep1) {
       excep1.printStackTrace();
    } catch (Exception excep) {
       excep.printStackTrace();
    } finally {
       try {
          if (stmt != null)
             conn.close();
       } catch (SQLException se) {}
       try {
          if (conn != null)
             conn.close();
       } catch (SQLException se) {
          se.printStackTrace();
       }  
    }
    System.out.println("Please check it in the MySQL Table");
    }

}

