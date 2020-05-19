/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jdbc.practice;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author HP
 */
public class ConnectionProvider {
    
    private static Connection con=null;
    public static Connection getConnection(){
     try
        {
            if(con==null){
           Class.forName("com.mysql.jdbc.Driver");
           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","root");
            } 
        }
        catch(Exception  e)
             {
                 System.out.println(e);
             }
     return con;
    }
}
