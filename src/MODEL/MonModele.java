/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import java.util.*;
import javax.swing.table.AbstractTableModel;
import java.sql.*;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dell
 */
public class MonModele extends AbstractTableModel{
    
    private int NbLig=0;
    private int NbCol;
    private String[] Titres;
    private ArrayList<Vector<String>> MesLignes = new ArrayList<Vector<String>>();
    
    public MonModele(ResultSet Rs){
        try
        {
            ResultSetMetaData rsmd = Rs.getMetaData();
            NbCol=rsmd.getColumnCount();
            Titres = new String[NbCol];
            for(int i=0; i<NbCol;i++){
                Titres[i]=rsmd.getColumnLabel(i+1);
            }
            Vector<String> Ligne;
            while(Rs.next()){
                Ligne = new Vector<String>();
                for(int i=0;i<NbCol;i++){
                    Ligne.add(Rs.getObject(i+1).toString());
                }
                MesLignes.add(Ligne);
                NbLig++;
            }
        }catch(SQLException ex){
            Logger.getLogger(MonModele.class.getName()).log(Level.SEVERE,null,ex);
        }
        
    }

    @Override
    public int getRowCount(){ return NbLig;}
        
    @Override
    public int getColumnCount(){return NbCol;}
        
    @Override
    public Object getValueAt(int rowIndex,int columnIndex){
        return MesLignes.get(rowIndex).get(columnIndex);
    }
    @Override
    public String getColumnName(int column){
        return Titres[column];
    }
}

