/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jdbc.practice;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author HP
 */
public class Deleteimg {
    
    public static void deleteimg(String str,Connection con)
    {
       try{
        String q="delete from bio where name=?";
        PreparedStatement stm=con.prepareStatement(q);
        stm.setString(1,str);
        stm.executeUpdate();
        }
       catch(Exception e)
       {
           System.out.println(e);
       }      
    
}
}
