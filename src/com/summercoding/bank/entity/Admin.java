/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.summercoding.bank.entity;

import com.summercoding.bank.utils.Jdbc;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.util.logging.Level;
//import java.util.logging.Logger;

/**
 *
 * @author King T1
 */
public class Admin {
    int idadmin;
    
    String login;
    
    String password;
    
    String nom;
    
    public int getIdadmin() {
        return idadmin;
    }

    public void setIdadmin(int idadmin) {
        this.idadmin = idadmin;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    
    
    public void save(String login, String password, String nom) throws SQLException{
        
        
            String command = "INSERT INTO `admin` ( `login`, `password`, `nom`) VALUES ( ?, ?, ?)";
            
            PreparedStatement addstmt = // PreparedStatement is an interface provided by JDBC
                                        // It represents a precompiled SQL statement that can be executed multiple times with different parameter values
                    
                    Jdbc.getConnexion().prepareStatement(command); //prepared statement object
            
            addstmt.setObject(1,login);
            addstmt.setObject(2,password);
            addstmt.setObject(3,nom);
            addstmt.execute(); // to execute the prepared statement
      
        }
    
    public void update(int idadmin, String login, String password, String nom) throws SQLException{
        
        
            String command = "UPDATE `admin` SET `login` = ?, `password` = ?, `nom` = ? WHERE `admin`.`idadmin` = ?";
            
            PreparedStatement addstmt = // PreparedStatement is an interface provided by JDBC
                                        // It represents a precompiled SQL statement that can be executed multiple times with different parameter values
                    
                    Jdbc.getConnexion().prepareStatement(command); //prepared statement object
            
            addstmt.setObject(1,login);
            addstmt.setObject(2,password);
            addstmt.setObject(3,nom);
            addstmt.setObject(4,idadmin);
            addstmt.execute(); // to execute the prepared statement
            
    }
    
    public void delete(int idadmin ) throws SQLException{
        
        
            String command = "DELETE FROM `admin` WHERE `admin`.`idadmin` = ?";
            
            PreparedStatement addstmt = // PreparedStatement is an interface provided by JDBC
                                        // It represents a precompiled SQL statement that can be executed multiple times with different parameter values
                    
                    Jdbc.getConnexion().prepareStatement(command); //prepared statement object
            
            addstmt.setObject(1,idadmin);
            
            addstmt.execute(); // to execute the prepared statement
            
    }

    
    public Admin getOne(int idadmin) throws SQLException {
        
        String cmd = "SELECT * FROM `admin` WHERE idadmin = ?";
        
        PreparedStatement stmt
                = Jdbc.getConnexion().prepareStatement(cmd);
        
        stmt.setObject(1, idadmin);
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()) {
            return new Admin (rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4));
        }
        return null;
    }
    
    
    public Admin getByLoginAndPassWord(String login, String password) throws SQLException {
        
        String cmd = "SELECT * FROM `admin` WHERE login= ? and password = ? ";
        
        PreparedStatement stmt
                = Jdbc.getConnexion().prepareStatement(cmd);
        
        stmt.setObject(1, login);
        stmt.setObject(2, password);
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()) {
            return new Admin (rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4));
        }
        return null;
    }
    
    
    public List<Admin> getAllAdmin() throws SQLException {
        
        String cmd = "SELECT * FROM `admin`";
        
        PreparedStatement stmt
                = Jdbc.getConnexion().prepareStatement(cmd);
        
        ResultSet rs = stmt.executeQuery();
        
        List<Admin> listAdmin = new ArrayList<>();
        
        
        while(rs.next()) {
            listAdmin.add(new Admin (rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4)));
        }
        return listAdmin;
    }

    public Admin() {
    }

    public Admin(int idadmin, String login, String password, String nom) {
        this.idadmin = idadmin;
        this.login = login;
        this.password = password;
        this.nom = nom;
    }
    
    
    @Override
    public String toString() {
        return "Admin{" + "idadmin=" + idadmin + ", login=" + login + ", password=" + password + ", nom=" + nom + '}';
    }    
    
    
    public static void main(String arg[]){
        
            //admin.save("cccc","ddd", "aaa");
        try {
            Admin admin = new Admin();
            String result = admin.getOne(3).toString();
            System.out.println(result);
            
            result = admin.getByLoginAndPassWord("ahah", "ahah").toString();
            System.out.println(result);
            
            result = admin.getAllAdmin().toString();
            System.out.println(result);
            
            //admin.delete(2);
            
            admin.update(5, "Qwerty", "Qwerty", "Qwerty");
           
//            result = admin.getAllAdmin().toString();
//            System.out.println(result);
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }


}
