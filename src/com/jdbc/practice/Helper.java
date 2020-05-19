/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jdbc.practice;

import java.awt.Image;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author HP
 */
public class Helper {
    
    public static ImageIcon getImageIconByname(String name,Connection con)
    {
        
            ImageIcon icon=null;
        try{
            String q="select image from bio where name=?";
            PreparedStatement pstm=con.prepareStatement(q);
            pstm.setString(1,name);
            ResultSet rs=pstm.executeQuery();
            if(rs.next())
            {
                Blob b=rs.getBlob("image");
                InputStream is=b.getBinaryStream();
                Image im=ImageIO.read(is);
                icon=new ImageIcon(im);
        
                
                
            } 
        } catch (Exception e) {
            System.out.println(e);
        }
        return icon;
    }

    
    
}
