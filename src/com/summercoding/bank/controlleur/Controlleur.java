/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.summercoding.bank.controlleur;

import com.summercoding.bank.entity.Admin;
import com.summercoding.bank.entity.Compte;
import com.summercoding.bank.entity.Utilisateur;
import com.summercoding.bank.gestionnaire.GestionnaireAdmin;
import com.summercoding.bank.gestionnaire.GestionnaireCompte;
import com.summercoding.bank.gestionnaire.GestionnaireUtilisateur;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author King T1
 */
public class Controlleur {
    GestionnaireAdmin gestionnaireAdmin = new GestionnaireAdmin();
    
    GestionnaireUtilisateur gestionnaireUtilisateur = new GestionnaireUtilisateur();
    
    GestionnaireCompte gestionnaireCompte = new GestionnaireCompte();
//    private Admin admin = new Admin();
    
    public Admin routeVerslogin(String login, String pwd) throws SQLException{
        
        return gestionnaireAdmin.login(login, pwd);
    }
    
    public void routeVersSaveAdmin(String login, String pwd, String nom) throws SQLException{
        
        gestionnaireAdmin.saveAdmin(login, pwd, nom);
    }
    
    public List<Admin> routeVersListAdmin() throws SQLException {
        
        return gestionnaireAdmin.GetAllAdminList();
        
    } 
    
    
    
    
    public Utilisateur routeVersUtilisateurLogin (String login, String password) throws SQLException{
        
        return gestionnaireUtilisateur.loginUtilisateur(login, password);
    }
    
    public void saveUtilisateur (String login, String nom, String prenom, String password, LocalDate datenaiss, String genre, int idadmin) throws SQLException {
        
           gestionnaireUtilisateur.saveUtilisateur(login, nom, prenom, password, datenaiss, genre, idadmin);
        
    }
    
    public List<Utilisateur> routeVersGetListUtilisateur () throws SQLException {
        
        return gestionnaireUtilisateur.getAllUtilisateurList();
    }
    
    
    
    
    public Compte routeVersLoginCompte (double solde, int iduser) throws SQLException {
        
        return gestionnaireCompte.loginCompte(solde, iduser);
    }
    
    public void routeVersSaveCompte (double solde, int iduser, int idadmin) throws SQLException {
        
        gestionnaireCompte.saveCompte(solde, iduser, idadmin);
    }
    
    public List<Compte> routeVersGetListCompte () throws SQLException {
        
        return gestionnaireCompte.getAllCompteListe();
    }

}
