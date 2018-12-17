/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import java.sql.Connection;
import java.sql.Statement;
import DAO.DaoBD;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author dell
 */
public class Etudiant {
    private Connection Con;
    private Statement St;
    private DaoBD dao;
    
    public Etudiant(){
        dao =   new DaoBD();
        dao.setPilote("com.mysql.jdbc.Driver");
        dao.setUrl("jdbc:mysql://localhost:3306/gestioneleves");
        dao.setLogin("root");
        dao.setPassword("");
        dao.SeConnecter();
        Con =   dao.getConnexion();
    }
    
   public void ALL_Student(){
        ResultSet Res;
        try{
            St=Con.createStatement();
            Res=St.executeQuery("Select Et.Nom,Et.Prenom,Et.age,Fl.code FROM Etudiant as Et, Filiere as Fl where Et.idf = Fl.idf ");
            while(Res.next()){
                System.out.println(Res.getString("Nom")+"\t"+Res.getString("Prenom")+"\t"+Res.getInt("age")+"\t\t"+Res.getString("code"));
            }
        }catch(SQLException ex){
            System.err.println("Erreur de la req select ou st "+ex.getMessage());
        }
    }
   
    public ResultSet LesEtudiants(){
        ResultSet res=null;
        try {
            St= Con.createStatement();
            res=St.executeQuery("Select Et.Nom,Et.Prenom,Et.age,Fl.code FROM Etudiant as Et, Filiere as Fl where Et.idf = Fl.idf");

        } catch (SQLException ex) {
            System.err.println("erreur dans la requete select ou st " + ex.getMessage());
        }
        return res;
    }
}
