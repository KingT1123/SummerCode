/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.summercoding.bank.gestionnaire;

import com.summercoding.bank.entity.Utilisateur;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author King T1
 */
public class GestionnaireUtilisateur {
    
    
    Utilisateur utilisateur = new Utilisateur ();
    
    
    
    public Utilisateur loginUtilisateur (String login, String password) throws SQLException{
        
        return utilisateur.getByLoginAndPassWord(login, password);
    }
    
    
    
    public void saveUtilisateur (String login, String nom, String prenom, String password, LocalDate datenaiss, String genre, int idadmin) throws SQLException {
        
        utilisateur.save(login, nom, prenom, password, datenaiss, genre, idadmin);
        
        
    }
    
    public List<Utilisateur> getAllUtilisateurList() throws SQLException {
        
        return utilisateur.getAllUsers();
    }
    
}
