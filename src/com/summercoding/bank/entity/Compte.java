/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

/**
 *
 * @author cynthiaabi
 */
public class Compte {
    int idcompte;
    
    double solde;
    
    int iduser;
    
    int idadmin;

    public int getIdcompte() {
        return idcompte;
    }

    public void setIdcompte(int idcompte) {
        this.idcompte = idcompte;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public int getIdadmin() {
        return idadmin;
    }

    public void setIdadmin(int idadmin) {
        this.idadmin = idadmin;
    }
    
    
    public void save (double solde, int iduser, int idadmin) throws SQLException{
        
       
           String command1 = "INSERT INTO `compte` ( `solde`, `iduser`, `idadmin`) VALUES ( ?, ?, ?)";
           
           PreparedStatement addstmt =
                    Jdbc.getConnexion().prepareStatement(command1);
            
            addstmt.setObject(1,solde);
            addstmt.setObject(2,iduser);
            addstmt.setObject(3,idadmin);
            addstmt.execute();
       }
    
    public void update(int idcompte, double solde, int iduser/*, int idadmin*/) throws SQLException{
        String command = "UPDATE `compte` SET `solde` = ?,`iduser` = ? WHERE `compte`.`idcompte` = ?";  /*, `idadmin` = ?*/
            
            PreparedStatement addstmt = // PreparedStatement is an interface provided by JDBC
                                        // It represents a precompiled SQL statement that can be executed multiple times with different parameter values
                    
                    Jdbc.getConnexion().prepareStatement(command); //prepared statement object
            
            addstmt.setObject(1,solde);
            addstmt.setObject(2,iduser);
            //addstmt.setObject(3,nom);
            addstmt.setObject(3,idcompte);
            addstmt.execute(); // to execute the prepared statement
    }
    
    public void delete(int idcompte ) throws SQLException{
        
        
            String command = "DELETE FROM `compte` WHERE `compte`.`idcompte` = ?";
            
            PreparedStatement addstmt = // PreparedStatement is an interface provided by JDBC
                                        // It represents a precompiled SQL statement that can be executed multiple times with different parameter values
                    
                    Jdbc.getConnexion().prepareStatement(command); //prepared statement object
            
            addstmt.setObject(1,idcompte);
            
            addstmt.execute(); // to execute the prepared statement
            
    }
    
    public Compte getOne(int idcompte) throws SQLException {
        
        String cmd = "SELECT * FROM `compte` WHERE idcompte = ?";
        
        PreparedStatement stmt
                = Jdbc.getConnexion().prepareStatement(cmd);
        
        stmt.setObject(1, idcompte);
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()) {
            return new Compte (rs.getInt(1), rs.getDouble(2),rs.getInt(3),rs.getInt(4));
        }
        return null;
    }
    
    
    
    public Compte getBySoldeAndIduser(Double solde, int iduser) throws SQLException {
        
        String cmd = "SELECT * FROM `compte` WHERE solde= ? and iduser = ? ";
        
        PreparedStatement stmt
                = Jdbc.getConnexion().prepareStatement(cmd);
        
        stmt.setObject(1, solde);
        stmt.setObject(2, iduser);
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()) {
            return new Compte (rs.getInt(1), rs.getDouble(2),rs.getInt(3),rs.getInt(4));
        }
        return null;
    }
    
    
    
    public List<Compte> getAllComptes() throws SQLException {
        
        String cmd = "SELECT * FROM `compte`";
        
        PreparedStatement stmt
                = Jdbc.getConnexion().prepareStatement(cmd);
        
        ResultSet rs = stmt.executeQuery();
        
        List<Compte> listCompte = new ArrayList<>();
        
        
        while(rs.next()) {
            listCompte.add(new Compte (rs.getInt(1),rs.getDouble(2),rs.getInt(3),rs.getInt(4)));
        }
        return listCompte;
    }
        

    public Compte() {
    }

    public Compte(int idcompte, double solde, int iduser, int idadmin) {
        this.idcompte = idcompte;
        this.solde = solde;
        this.iduser = iduser;
        this.idadmin = idadmin;
    }
    
    
    @Override
    public String toString() {
        return "Compte{" + "idcompte=" + idcompte + ", solde=" + solde + ", iduser=" + iduser + ", idadmin=" + idadmin + '}';
    }    
    
    
    
    
     public static void main(String args[]){
        try {
            Compte compte = new Compte();
            //compte.save(55005.77,3,10);
            List<Compte> res = compte.getAllComptes();
            System.out.println(res);
        } catch (SQLException ex) {
            Logger.getLogger(Compte.class.getName()).log(Level.SEVERE, null, ex);
        }
     
}
}
