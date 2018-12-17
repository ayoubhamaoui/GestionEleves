/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioneleves;

import MODEL.Etudiant;
import java.sql.SQLException;
/**
 *
 * @author dell
 */
public class GestionEleves {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        Etudiant Et = new Etudiant();
        //Et.Create("GINF2", "Belal", "Nafar", 22);
        Et.ALL_Student();
        
    }
    
}
