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

/**
 *
 * @author
 */
public class conexaoEndereco{
    
    /**
     *
     * @param end
     * @return
     */
    public boolean cadastroEndereco(Endereco end){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        if (end.getRua().equals("") || end.getCEP().equals("") || end.getCidade().equals("") || end.getEstado().equals("")){
                ConnectionFactory.closeConnection(con, stmt);
                return false;   
            }
        
        try {
            
            stmt = (PreparedStatement) con.prepareStatement("INSERT INTO ENDERECO VALUES(?,?,?,?,?,?)");
            
            stmt.setInt(1, end.getEnderecoId());
            stmt.setString(2, end.getRua());
            stmt.setInt(3,(int) end.getNumero());
            stmt.setString(4, end.getCEP());
            stmt.setString(5, end.getCidade());
            stmt.setString(6, end.getEstado());
            stmt.executeUpdate();
            
            ConnectionFactory.closeConnection(con, stmt);
            return true;
            
        } catch (SQLException ex) {
            
            Logger.getLogger(conexaoEndereco.class.getName()).log(Level.SEVERE, null, ex);
            ConnectionFactory.closeConnection(con, stmt);
            return false;
        }
    }
    
    public Endereco readInfo(int end_codigo){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
        
            stmt = (PreparedStatement) con.prepareStatement("SELECT * FROM ENDERECO WHERE end_codigo = ?");
            stmt.setInt(1, end_codigo);
            
            rs = stmt.executeQuery();
            
            Endereco end = new Endereco();
            
            while(rs.next()){
            
                end.setRua(rs.getString("end_rua"));
                end.setNumero(rs.getInt("end_numero"));
                end.setCEP(rs.getString("end_cep"));
                end.setCidade(rs.getString("end_cidade"));
                end.setEstado(rs.getString("end_estado"));
            }
            
            ConnectionFactory.closeConnection(con, stmt, rs);
            return end;
            
        
        } catch(SQLException ex){
            
            Logger.getLogger(conexaoEndereco.class.getName()).log(Level.SEVERE, null, ex);
            ConnectionFactory.closeConnection(con, stmt, rs);
            return null;
        
        }
    
    }
}