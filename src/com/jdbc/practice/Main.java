/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jdbc.practice;

/**
 *
 * @author HP
 */
import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
public class Main {
 
    private static Connection con=null;
    public static void main(String[] args) {
       try{
        Connection con=ConnectionProvider.getConnection();
        String q="insert into bio(name,image) values(?,?)";
        PreparedStatement stm=con.prepareStatement(q);
        stm.setString(1,"preeti");
        JFileChooser jfc=new JFileChooser();
        jfc.showOpenDialog(null);
        File f=jfc.getSelectedFile();
        FileInputStream fis=new FileInputStream(f);
        stm.setBinaryStream(2,fis,fis.available());
        stm.executeUpdate();
        //
        JOptionPane.showMessageDialog(null,"SUCCESS FULLY");
    }
    catch(Exception e){System.out.println(e);}
    }
    
}
