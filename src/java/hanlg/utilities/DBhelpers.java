/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanlg.utilities;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author hanlg
 */
public class DBhelpers implements Serializable{
    public static Connection makeConnection() throws NamingException, SQLException, ClassNotFoundException{
////1. get current context
//Context context = new InitialContext();
////2 get server context
//Context tomcatContext = (Context) context.lookup("java:comp/env");
////3 . get data source
//DataSource ds =(DataSource) tomcatContext.lookup("SE1419DS");
////4 make connection
//Connection con = ds.getConnection();

 //load driver
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
      String url ="jdbc:sqlserver://localhost:1433;databaseName= QuizOnline";
       Connection con = DriverManager.getConnection(url,"sa","12345");
     
        return con;
        
    }
}
