/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import com.mysql.jdbc.PreparedStatement;
import Conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class conexaoModalidade{
    
    public boolean cadastroModalidade(Modalidade mod){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        if (mod.getNome().equals("")){
                ConnectionFactory.closeConnection(con, stmt);
                return false;   
            }
        
        try {
            
            stmt = (PreparedStatement) con.prepareStatement("INSERT INTO MODALIDADE VALUES(?,?,?,?)");
            
            stmt.setInt(1, mod.getId());
            stmt.setString(2, mod.getNome());
            stmt.setInt(3, (int)mod.getValor());
            stmt.setInt(4, (int) mod.getFrequencia());
            stmt.executeUpdate();
            
            ConnectionFactory.closeConnection(con, stmt);
            return true;
            
        } catch (SQLException ex) {
            
            Logger.getLogger(conexaoModalidade.class.getName()).log(Level.SEVERE, null, ex);
            ConnectionFactory.closeConnection(con, stmt);
            return false;
        }
    }
    
    public Modalidade readInfo(int mod_codigo){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
        
            stmt = (PreparedStatement) con.prepareStatement("SELECT * FROM MODALIDADE WHERE mod_codigo = ?");
            stmt.setInt(1, mod_codigo);
            
            rs = stmt.executeQuery();
            
            Modalidade mod = new Modalidade();
            
            while(rs.next()){
            
                mod.setNome(rs.getString("mod_nome"));
                mod.setValor(rs.getInt("mod_frequencia"));
                mod.setFrequencia(rs.getInt("mod_preco"));
            
            }
            
            ConnectionFactory.closeConnection(con, stmt, rs);
            return mod;
            
        
        } catch(SQLException ex){
            
            Logger.getLogger(conexaoModalidade.class.getName()).log(Level.SEVERE, null, ex);
            ConnectionFactory.closeConnection(con, stmt, rs);
            return null;
        
        }
    
    }
    
    //Listar modalidades
    
    public List<Modalidade> listaModalidade(){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
            List<Modalidade> lista = new ArrayList<Modalidade>();
                    
            stmt = (PreparedStatement) con.prepareStatement("SELECT * FROM MODALIDADE");
                    
            rs = stmt.executeQuery();
                    
            while(rs.next()){
                Modalidade mod = new Modalidade();
                mod.setId(rs.getInt("mod_codigo"));
                mod.setNome(rs.getString("mod_nome"));
                mod.setValor(rs.getInt("mod_frequencia"));
                mod.setFrequencia(rs.getInt("mod_preco"));
                
                lista.add(mod);
             }
            
            return lista;
            
        }catch(SQLException ex){
            
            Logger.getLogger(conexaoModalidade.class.getName()).log(Level.SEVERE, null, ex);
            ConnectionFactory.closeConnection(con, stmt, rs);
            return null;
        
        }
        
        
    
    }
}