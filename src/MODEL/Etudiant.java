/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import java.sql.Connection;
import java.sql.Statement;
import DAO.DaoBD;
import java.sql.PreparedStatement;
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
    
     public void Add(String code, String Nom,String Prenom,int age){
         int idf;
         ResultSet Res;
        try{
            // requet pour retourner id de la filiere
            St=Con.createStatement();
            Res=St.executeQuery("Select idf from Filiere where code='"+code+"'");
            
            //positionner cursseur dans la premiere ligne apres affecter la valeur a idf
            Res.next();
            idf = Res.getInt("idf");
            
            PreparedStatement Pst   =   Con.prepareStatement("insert into Etudiant(idf,Nom,Prenom,age) values(?,?,?,?)");
            Pst.setInt(1, idf);
            Pst.setString(2, Nom);
            Pst.setString(3,Prenom);
            Pst.setInt(4, age);
            Pst.executeUpdate();
            System.out.println("Ajout effectué avec succès");
        }
        catch(SQLException ex){
            System.err.println("Erreur dans la req Add "+ex.getMessage());
        }
    }
    
   public void ALL_Student(){
        ResultSet Res;
        try{
            St=Con.createStatement();
            Res=St.executeQuery("Select Et.Nom,Et.Prenom,Et.age,Fl.code FROM Etudiant as Et, Filiere as Fl where Et.idf = Fl.idf order by Fl.code");
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
            res=St.executeQuery("Select Et.Nom,Et.Prenom,Et.age,Fl.code FROM Etudiant as Et, Filiere as Fl where Et.idf = Fl.idf order by code");
            

        } catch (SQLException ex) {
            System.err.println("erreur dans la requete select ou st " + ex.getMessage());
        }
        return res;
    }
    
      public void Create(String code, String Nom,String Prenom,int age) throws SQLException{
        String Req;
        int idf;
        ResultSet Res;
        try{
            St=Con.createStatement();
            Res=St.executeQuery("Select idf from Filiere where code='"+code+"'");
            //positionner cursseur dans la premiere ligne apres affecter la valeur a idf
            Res.next();
            idf = Res.getInt("idf");
            
            Req="insert into Etudiant(idf,Nom,Prenom,age) values('"+idf+"','"+Nom+"','"+Prenom+"','"+age+"');";
            if(Con!=null){
                St  =   Con.createStatement();
                St.executeUpdate(Req);
            }
        }
        catch(SQLException ex){
            System.out.println("Erreur dans la requete Create:"+ex.getMessage());
        }
    }
}
