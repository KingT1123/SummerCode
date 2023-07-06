/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.summercoding.bank.gestionnaire;

import com.summercoding.bank.entity.Compte;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author King T1
 */
public class GestionnaireCompte {
    
    Compte compte = new Compte();
    
    public Compte loginCompte (double solde, int iduser) throws SQLException {
        
        return compte.getBySoldeAndIduser(solde, iduser);
    }
    
    public void saveCompte (double solde, int iduser, int idadmin) throws SQLException {
        
        compte.save(solde, iduser, idadmin);
    }
    
    public List<Compte> getAllCompteListe () throws SQLException {
        
        return compte.getAllComptes();
    }
    
}
